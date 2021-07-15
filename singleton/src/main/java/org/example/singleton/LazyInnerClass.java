package org.example.singleton;

public class LazyInnerClass {

    private LazyInnerClass() {
        if (LazyHolder.instance != null) {
            throw new RuntimeException("Illegal request");
        }
    }

    public static LazyInnerClass getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LazyInnerClass instance = new LazyInnerClass();
    }

}
