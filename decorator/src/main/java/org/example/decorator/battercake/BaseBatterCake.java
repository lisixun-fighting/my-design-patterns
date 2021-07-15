package org.example.decorator.battercake;

public class BaseBatterCake extends BatterCake {
    @Override
    protected String getMsg() {
        return "BatterCake";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
