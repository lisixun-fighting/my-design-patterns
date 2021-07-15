package org.example.decorator.battercake;

public class SausageDecorator extends BatterCakeDecorator {
    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + " + 1 sausage";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
