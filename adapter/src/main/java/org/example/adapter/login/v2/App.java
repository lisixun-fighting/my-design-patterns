package org.example.adapter.login.v2;

import org.example.adapter.login.ResultMsg;
import org.example.adapter.login.SignInService;

public class App {
    public static void main(String[] args) {
        SignInService service = new PassportForThirdAdapter();
        ResultMsg msg = service.login("11", "haha");
        System.out.println(msg);

        IPassportForThird passport = new PassportForThirdAdapter();
        ResultMsg msg1 = passport.loginForQQ("2738041696");
        System.out.println(msg1);
    }
}
