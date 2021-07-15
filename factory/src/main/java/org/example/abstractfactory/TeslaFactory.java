package org.example.abstractfactory;

public class TeslaFactory implements ICarFactory {
    @Override
    public IEngine createEngine() {
        return new TeslaEngine();
    }

    @Override
    public IWheels createWheels() {
        return new TeslaWheels();
    }

    @Override
    public IWindow createWindow() {
        return new TeslaWindow();
    }
}
