package org.example.singleton;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class App {

    @Test
    public void testLazyInnerClass() {
        LazyInnerClass o1 = LazyInnerClass.getInstance();
        LazyInnerClass o2 = LazyInnerClass.getInstance();
        System.out.println(o1 == o2);
    }

    @Test
    public void testSerializableSingleton() {
        SerializableSingleton s1 = null;
        SerializableSingleton s2 = SerializableSingleton.instance;
        try (FileOutputStream out = new FileOutputStream("tmp.obj")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
                oos.writeObject(s2);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileInputStream in = new FileInputStream("tmp.obj")) {
            try (ObjectInputStream ois = new ObjectInputStream(in)) {
                s1 = (SerializableSingleton) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    @Test
    public void testEnumSingleton() {
        EnumSingleton s1 = null;
        EnumSingleton s2 = EnumSingleton.INSTANCE;
        try (FileOutputStream out = new FileOutputStream("tmp.obj")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
                oos.writeObject(s2);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileInputStream in = new FileInputStream("tmp.obj")) {
            try (ObjectInputStream ois = new ObjectInputStream(in)) {
                s1 = (EnumSingleton) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);

    }

    @Test
    public void testTreadLocalSingleton() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ThreadLocalSingleton.getInstance());
                System.out.println(Thread.currentThread().getName() + ThreadLocalSingleton.getInstance());
                System.out.println(Thread.currentThread().getName() + ThreadLocalSingleton.getInstance());
            }).start();
        }
        TimeUnit.MILLISECONDS.sleep(50);
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = EnumSingleton.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Object o1 = constructor.newInstance();
            Object o2 = constructor.newInstance();
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
