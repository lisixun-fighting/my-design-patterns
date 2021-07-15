package org.example.staticproxy.dbroute.db;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object proxied;

    public OrderServiceDynamicProxy(Object proxied) {
        this.proxied = proxied;
    }



    private void after() {
        System.out.println("Proxy after Method.");
    }

    private void before() {
        System.out.println("Proxy before Method.");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(proxied, args);
        after();
        return obj;
    }
}
