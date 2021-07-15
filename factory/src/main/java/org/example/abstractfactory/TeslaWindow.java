package org.example.abstractfactory;

public class TeslaWindow implements IWindow {
    @Override
    public void open() {
        System.out.println("TeslaWindow open");
    }
}
