package org.example.observer.events;

import org.example.observer.events.mouseevent.Mouse;
import org.example.observer.events.mouseevent.MouseEventCallback;
import org.example.observer.events.mouseevent.MouseEventType;

public class App {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK.name(), callback);
        mouse.addListener(MouseEventType.ON_DOUBLECLICK.name(), callback);
        mouse.addListener(MouseEventType.ON_UP.name(), callback);
        mouse.addListener(MouseEventType.ON_DOWN.name(), callback);

        mouse.click();

    }
}
