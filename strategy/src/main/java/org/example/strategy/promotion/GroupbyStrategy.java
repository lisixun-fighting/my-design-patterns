package org.example.strategy.promotion;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GroupbyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团");
    }
}
