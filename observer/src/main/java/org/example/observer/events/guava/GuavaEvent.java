package org.example.observer.events.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        System.out.println(this + " subscribe() : " + str);
    }

}
