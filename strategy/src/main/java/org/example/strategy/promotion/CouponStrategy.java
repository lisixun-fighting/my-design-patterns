package org.example.strategy.promotion;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券");
    }
}
