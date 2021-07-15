package org.example.decorator.battercake;

public class EggDecorator extends BatterCakeDecorator {

    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + " + 1 egg";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
