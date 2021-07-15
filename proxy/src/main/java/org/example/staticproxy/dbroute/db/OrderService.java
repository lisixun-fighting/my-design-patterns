package org.example.staticproxy.dbroute.db;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService implements IOrderService {

    private OrderDao orderDao;

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService 调用 orderDao");
        return orderDao.insert(order);
    }
}
