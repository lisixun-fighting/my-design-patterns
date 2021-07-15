package org.example.singleton;

public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> instance = new ThreadLocal<>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    private ThreadLocalSingleton() {}
    public static ThreadLocalSingleton getInstance() {
        return instance.get();
    }
}
