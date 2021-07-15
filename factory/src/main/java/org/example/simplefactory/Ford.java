package org.example.simplefactory;

public class Ford implements ICar {
    @Override
    public void move() {
        System.out.println("Ford moving");
    }
}
