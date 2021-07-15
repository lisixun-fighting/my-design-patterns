package org.example.singleton;

public class LazyDoubleCheck {
    private volatile static LazyDoubleCheck instance = null;

    public static LazyDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheck.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheck();
                }
            }
        }
        return instance;
    }

    private LazyDoubleCheck() {
        if (instance != null) {
            throw new RuntimeException("Illegal request!");
        }
    }

}
