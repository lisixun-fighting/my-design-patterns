package org.example.observer.gperadvice;

public class Teacher implements Observer {

    @Override
    public void update(Question question) {
        System.out.println("Teacher has noted the " + question.getContent() +
                " from " + question.getUsername());
    }
}
