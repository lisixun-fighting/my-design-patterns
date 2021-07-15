package org.example.simplefactory;

public class Tesla implements ICar {
    @Override
    public void move() {
        System.out.println("Tesla moving");
    }
}
