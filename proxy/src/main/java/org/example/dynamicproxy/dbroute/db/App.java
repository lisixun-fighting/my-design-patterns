package org.example.dynamicproxy.dbroute.db;

import org.example.staticproxy.dbroute.db.IOrderService;
import org.example.staticproxy.dbroute.db.Order;
import org.example.staticproxy.dbroute.db.OrderDao;
import org.example.staticproxy.dbroute.db.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws ParseException {
        OrderServiceDynamicProxy proxy = new OrderServiceDynamicProxy();
        IOrderService obj = (IOrderService) proxy.getInstance(new OrderService(new OrderDao()));

        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2021-7-14");
        order.setCreateTime(date.getTime());
        obj.createOrder(order);
    }
}
