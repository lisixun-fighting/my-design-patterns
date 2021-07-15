package org.example.observer.events.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EventListener {

    protected Map<String,Event> events = new HashMap<>();

    public void addListener(String eventType, Object target) {
        try {
            this.addListener(eventType, target,
                    target.getClass().getMethod(
                            "on"+eventType.split("_")[1].toLowerCase(Locale.ROOT), Event.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void addListener(String eventType, Object target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.nanoTime());
        try {
            if (event.getCallback() != null) {
                event.getCallback().invoke(event.getTarget(), event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }

}
