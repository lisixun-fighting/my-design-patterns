package org.example.decorator.battercake;

public class App {
    public static void main(String[] args) {
        BatterCake cake = new BaseBatterCake();
        System.out.println(cake.getMsg() + " " + cake.getPrice());
        cake = new EggDecorator(cake);
        System.out.println(cake.getMsg() + " " + cake.getPrice());
        cake = new SausageDecorator(cake);
        System.out.println(cake.getMsg() + " " + cake.getPrice());
        cake = new SausageDecorator(cake);
        System.out.println(cake.getMsg() + " " + cake.getPrice());
    }
}
