package org.example.observer.events.mouseevent;

import org.example.observer.events.core.Event;

public class MouseEventCallback {

    public void onclick(Event e) {
        System.out.println("---- Trigger event Mouse onClick ---- \n" + e);
    }
    public void ondoubleclick(Event e) {
        System.out.println("---- Trigger event Mouse onDoubleClick ---- \n" + e);
    }
    public void onup(Event e) {
        System.out.println("---- Trigger event Mouse onUp ---- \n" + e);
    }
    public void ondown(Event e) {
        System.out.println("---- Trigger event Mouse onDown ---- \n" + e);
    }
    public void onmove(Event e) {
        System.out.println("---- Trigger event Mouse onMove ---- \n" + e);
    }
    public void onwheel(Event e) {
        System.out.println("---- Trigger event Mouse onWheel ---- \n" + e);
    }
}
