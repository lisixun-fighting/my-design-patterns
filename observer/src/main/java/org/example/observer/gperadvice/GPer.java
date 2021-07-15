package org.example.observer.gperadvice;


import java.util.List;

public class GPer {

    private String name = "GPer生态圈";
    private static GPer gPer = null;
    private GPer() {}
    List<Observer> observers = List.of(new Teacher());

    public static GPer getInstance() {
        if (gPer == null) {
            gPer = new GPer();
        }
        return gPer;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + " poll a question " + question.getContent()
         + " on " + this.getName());
        for (Observer o : observers) {
            o.update(question);
        }
    }

}
