package org.example.strategy.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PromotionActivity {

    private PromotionStrategy strategy;

    public void execute() {
        strategy.doPromotion();
    }

}
