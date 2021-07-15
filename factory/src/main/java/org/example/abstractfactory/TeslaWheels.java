package org.example.abstractfactory;

public class TeslaWheels implements IWheels {
    @Override
    public void rotate() {
        System.out.println(this.getClass().getSimpleName() + " rotate");
    }
}
