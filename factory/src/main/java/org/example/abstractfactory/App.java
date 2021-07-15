package org.example.abstractfactory;

public class App {
    public static void main(String[] args) {
        ICarFactory factory = new TeslaFactory();
        IEngine engine = factory.createEngine();
        IWheels wheels = factory.createWheels();
        IWindow window = factory.createWindow();
        engine.work();
        wheels.rotate();
        window.open();
    }
}
