package org.example.prototype;

import java.util.List;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA();
        prototypeA.setAge(18);
        prototypeA.setName("prototype");
        prototypeA.setHobbies(List.of("swimming"));
        System.out.println(prototypeA);

        Client client = new Client(prototypeA);
        Prototype clonetypeA = client.startClone(prototypeA);
        System.out.println(clonetypeA);

    }
}
