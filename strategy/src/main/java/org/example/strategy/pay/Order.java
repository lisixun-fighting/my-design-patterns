package org.example.strategy.pay;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {
    private String uid;
    private String oid;
    private double amount;

    public PayState pay(PayStrategy strategy) {
        Payment payment = strategy.getInstance();
        System.out.println("欢迎使用 " + payment.getName());
        return payment.pay(uid, amount);
    }

}
