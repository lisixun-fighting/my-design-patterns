package org.example.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private ContainerSingleton() {}
    private final static Map<String, Object> ioc = new ConcurrentHashMap<>();
    public static Object getBean(String classname) {
        synchronized (ioc) {
            if (!ioc.containsKey(classname)) {
                Object obj = null;
                try {
                    obj = Class.forName(classname).getDeclaredConstructor().newInstance();
                    ioc.put(classname, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(classname);
            }
        }
    }
}
