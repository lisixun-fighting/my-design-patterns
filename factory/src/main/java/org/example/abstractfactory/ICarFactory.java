package org.example.abstractfactory;

public interface ICarFactory {

    IEngine createEngine();

    IWheels createWheels();

    IWindow createWindow();

}
