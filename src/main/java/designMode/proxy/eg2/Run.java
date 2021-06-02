package designMode.proxy.eg2;


import designMode.proxy.eg2.ProxyInvocationHandler;
import designMode.proxy.eg2.User;
import designMode.proxy.eg2.UserImp;

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
        Class<?>[] interfaces = userImp.getClass().getInterfaces();
        User user = (User) Proxy.newProxyInstance(proxyInvocationHandler.getClass().getClassLoader(),interfaces, proxyInvocationHandler);

        //User user = (User) Proxy.newProxyInstance(proxyInvocationHandler.getClass().getClassLoader(), userImp.getClass().getInterfaces(), proxyInvocationHandler);

        user.sell();
    }
}
