package org.example.factorymethod;

import org.example.simplefactory.Benz;
import org.example.simplefactory.ICar;

public class BenzFactory implements ICarFactory {
    @Override
    public ICar generate() {
        return new Benz();
    }
}
