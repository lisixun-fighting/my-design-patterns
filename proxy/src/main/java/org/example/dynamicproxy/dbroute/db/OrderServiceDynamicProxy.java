package org.example.dynamicproxy.dbroute.db;

import org.example.staticproxy.dbroute.db.DynamicDataSourceEntry;
import org.example.staticproxy.dbroute.db.IOrderService;
import org.example.staticproxy.dbroute.db.Order;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object proxied;

    public Object getInstance(Object proxied) {
        this.proxied = proxied;
        Class<?> clazz = proxied.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    private void after() {
        System.out.println("Proxy after Method.");
    }

    private void before(Object target) {
        System.out.println("Proxy before Method.");
        try {
            System.out.println(target);
            Long time = (Long) target.getClass().getDeclaredMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.parseInt(yearFormat.format(time));
            System.out.println("静态代理类自动分派到 【DB_" + dbRouter + "】");
            DynamicDataSourceEntry.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(Arrays.toString(args));
        before(args);
        Object obj = method.invoke(proxied, args);
        after();
        return obj;
    }

}
