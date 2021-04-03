package proxy;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    //被代理的接口
    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }


    //
    /**
    * @Description: proxyInvocationHandler.getProxy()生成的实例在执行代理对象的方法时会调用这里自定义的invoke()方法
    * @Param: [proxy, method, args] method参数是根据调用的方法来传值的  比如调用sell()方法 则会把sell方法的属性传过来
    * @return: java.lang.Object
    * @Author: Mr.Pan
    * @Date: 2021/3/28
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("测试");


        method.invoke(target,args);


        return null;
    }


}
