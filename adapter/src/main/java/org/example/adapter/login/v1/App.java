package org.example.adapter.login.v1;

import org.example.adapter.login.ResultMsg;

public class App {
    public static void main(String[] args) {
        SignInForThirdService service = new SignInForThirdService();
        ResultMsg msg = service.loginForQQ("asdflkajdf19013");
        System.out.println(msg);
    }
}
