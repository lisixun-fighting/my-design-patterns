package org.example.observer.events.core;

import lombok.Getter;
import lombok.ToString;

import java.lang.reflect.Method;

@Getter
@ToString
public class Event {
    private Object source;
    private Object target;
    private Method callback;
    private String trigger;
    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }
}
