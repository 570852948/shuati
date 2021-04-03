package Data;



import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;
//import com.mysql.jdbc.Driver;
import javax.sql.DataSource;

import org.junit.Test;
import org.omg.PortableServer.POA;

public class JdbcPool implements DataSource{


    private static final LinkedList<Connection> listConnections = new LinkedList<>();

    static {
        //静态代码块中加载db.properties配置文件
        InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");

        Properties prop = new Properties();
        try {
            //读取文件内容
            prop.load(in);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            //数据库连接池的初始化连接大小
            int jdbcPoolInitSize = Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));
            //加载数据库驱动  需要加载的原因是该类中有静态块  需要初始化  如果是import也就相当于加载类到类加载器
            Class.forName(driver);
            System.out.println(com.mysql.jdbc.Driver.class.getClassLoader().getParent());

            //new com.mysql.cj.jdbc.Driver();
            for(int i=0; i<jdbcPoolInitSize; i++) {
                //获取连接
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("获取连接："+conn);
                //将conn连接加入listConnections集合中，此时的listConnections就是一个连接池
                listConnections.add(conn);


            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    @Override
    public Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        //如果数据库连接池的连接数大于0
        System.out.println("进来了");
        if (listConnections.size()>0) {
            //从listConnections中获取一个连接
            final Connection conn = listConnections.removeFirst();
            System.out.println("数据库连接池的大小为："+listConnections.size());
            //返回Connection的代理，利用代理可以处理一些横切事件
            System.out.println("取出的连接为："+conn);
            return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // TODO Auto-generated method stub
                    //如果不是执行关闭操作，则通过反射执行相应方法
                    if (!method.getName().equals("close")) {

                        return method.invoke(conn, args);

                    }else {
                        //否则，将conn归还给连接池
                        listConnections.add(conn);
                        System.out.println("归还连接："+conn);
                        System.out.println("连接池大小为："+listConnections.size());
                        return null;
                    }

                }
            });

        }else {
            throw new RuntimeException("对不起，数据库正忙");
        }

    }
    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }


    @Test
    public void Y() {
        JdbcPool jdbcPool = new JdbcPool();
        try {
            jdbcPool.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
