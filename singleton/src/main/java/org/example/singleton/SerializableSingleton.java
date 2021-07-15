package org.example.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    public static final SerializableSingleton instance = new SerializableSingleton();

    private SerializableSingleton() {}

    public static SerializableSingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
