package org.example.factorymethod;

import org.example.simplefactory.ICar;
import org.example.simplefactory.Tesla;

public class TeslaFactory implements ICarFactory {
    @Override
    public ICar generate() {
        return new Tesla();
    }
}
