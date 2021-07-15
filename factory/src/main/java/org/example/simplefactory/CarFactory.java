package org.example.simplefactory;

import java.lang.reflect.InvocationTargetException;

public class CarFactory {

    public static ICar generate(Class<? extends ICar> carType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return carType.getConstructor().newInstance();
    }

}
