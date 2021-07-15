package org.example.strategy.promotion;

public class App {
    public static void main(String[] args) {
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.COUPON.getStrategy();
        PromotionActivity activity = new PromotionActivity(promotionStrategy);
        activity.execute();
    }
}
