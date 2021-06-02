package designMode.proxy;


import java.lang.reflect.Proxy;

public class Run {

    public static void main(String[] args) {
        //    我们要代理的真实对象
        UserImp userImp = new UserImp();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //设置代理的接口
        proxyInvocationHandler.setTarget(userImp);

        //User user = (User) proxyInvocationHandler.getProxy();
        Class[] classes = {User.class};
        User user = (User) Proxy.newProxyInstance(proxyInvocationHandler.getClass().getClassLoader(),classes, proxyInvocationHandler);

        //User user = (User) Proxy.newProxyInstance(proxyInvocationHandler.getClass().getClassLoader(), userImp.getClass().getInterfaces(), proxyInvocationHandler);

        user.sell();
    }
}
