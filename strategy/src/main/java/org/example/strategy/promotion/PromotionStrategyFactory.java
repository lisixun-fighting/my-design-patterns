package org.example.strategy.promotion;

public enum PromotionStrategyFactory {

    COUPON(new CouponStrategy()),
    CASHBACK(new CashbackStrategy()),
    GROUPBUY(new GroupbyStrategy());

    private PromotionStrategy strategy;

    PromotionStrategyFactory(PromotionStrategy strategy) {
        this.strategy = strategy;
    }

    PromotionStrategy getStrategy() {
        return strategy;
    }
}
