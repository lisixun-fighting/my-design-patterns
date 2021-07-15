package org.example.strategy.pay;

public class App {
    public static void main(String[] args) {
        Order order = new Order("1", "20210714001000001", 324.25);
        PayState payState = order.pay(PayStrategy.WECHATPAY);
        System.out.println(payState);
    }
}
