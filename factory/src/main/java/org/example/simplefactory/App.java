package org.example.simplefactory;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ICar car = CarFactory.generate(Ford.class);
        car.move();
    }
}
