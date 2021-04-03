package proxy;

import java.lang.reflect.Proxy;

public class Run {

    public static void main(String[] args) {
        //    我们要代理的真实对象
        UserImp userImp = new UserImp();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(userImp);

        User user = (User) proxyInvocationHandler.getProxy();
        //User user = (User) Proxy.newProxyInstance(proxyInvocationHandler.getClass().getClassLoader(), userImp.getClass().getInterfaces(), proxyInvocationHandler);

        user.sell();
    }
}
