package org.example.decorator.battercake;

public class BatterCakeDecorator extends BatterCake {

    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    @Override
    protected String getMsg() {
        return batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return batterCake.getPrice();
    }
}
