package org.example.strategy.pay;

public enum PayStrategy {
    ALIPAY(new AliPay()),
    WECHATPAY(new WechatPay());

    private final Payment payment;

    PayStrategy(Payment payment) {
        this.payment = payment;
    }

    Payment getInstance() {
        return payment;
    }
}
