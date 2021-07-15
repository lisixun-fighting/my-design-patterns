package org.example.observer.events.mouseevent;

import org.example.observer.events.core.EventListener;

public class Mouse extends EventListener {

    public void click() {
        System.out.println("Mouse click()");
        this.trigger(MouseEventType.ON_CLICK.name());
    }

    public void doubleclick() {
        System.out.println("Mouse doubleClick()");
        this.trigger(MouseEventType.ON_DOUBLECLICK.name());
    }

    public void up() {
        System.out.println("Mouse up()");
        this.trigger(MouseEventType.ON_UP.name());
    }

    public void down() {
        System.out.println("Mouse down()");
        this.trigger(MouseEventType.ON_DOWN.name());
    }

    public void move() {
        System.out.println("Mouse move()");
        this.trigger(MouseEventType.ON_MOVE.name());
    }

    public void wheel() {
        System.out.println("Mouse wheel()");
        this.trigger(MouseEventType.ON_WHEEL.name());
    }

}
