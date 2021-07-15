package org.example.prototype;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ConcretePrototypeA implements Prototype {

    private int age;
    private String name;
    private List<String> hobbies;

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(age);
        concretePrototype.setHobbies(hobbies);
        concretePrototype.setName(name);
        return concretePrototype;
    }
}
