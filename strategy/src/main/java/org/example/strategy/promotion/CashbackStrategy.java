package org.example.strategy.promotion;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销");
    }
}
