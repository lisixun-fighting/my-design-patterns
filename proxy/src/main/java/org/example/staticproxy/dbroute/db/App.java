package org.example.staticproxy.dbroute.db;

import javax.xml.crypto.Data;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {
//        try {
//            Order order = new Order();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = sdf.parse("2021-7-14");
//            order.setCreateTime(date.getTime());
//
//            IOrderService orderService = new OrderServiceStaticProxy(new OrderService(new OrderDao()));
//            orderService.createOrder(order);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        IOrderService orderService = new OrderService(new OrderDao());
        IOrderService proxy = (IOrderService) Proxy.newProxyInstance(OrderService.class.getClassLoader(), OrderService.class.getInterfaces(),
                new OrderServiceDynamicProxy(orderService));
        proxy.createOrder(new Order());
    }
}
