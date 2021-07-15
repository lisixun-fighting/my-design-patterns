package org.example.strategy.promotion;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
