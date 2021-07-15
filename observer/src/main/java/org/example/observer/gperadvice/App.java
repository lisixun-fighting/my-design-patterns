package org.example.observer.gperadvice;

public class App {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        gPer.publishQuestion(new Question());
    }
}
