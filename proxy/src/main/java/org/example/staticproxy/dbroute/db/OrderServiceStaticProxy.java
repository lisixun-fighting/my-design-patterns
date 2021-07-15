package org.example.staticproxy.dbroute.db;

import java.text.SimpleDateFormat;

public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long createTime = order.getCreateTime();
        Integer dbRouter = Integer.parseInt(yearFormat.format(createTime));
        System.out.println("静态代理类自动分派到 【DB_" + dbRouter + "】");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("Proxy after Method.");
    }

    private void before() {
        System.out.println("Proxy before Method.");
    }
}
