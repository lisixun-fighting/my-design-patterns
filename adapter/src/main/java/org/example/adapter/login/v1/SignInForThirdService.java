package org.example.adapter.login.v1;

import org.example.adapter.login.ResultMsg;
import org.example.adapter.login.SignInService;

public class SignInForThirdService extends SignInService {

    public ResultMsg loginForQQ(String openId) {
        return login(openId, "QQ_EMPTY");
    }

    public ResultMsg loginForWechat(String openId) {
        return login(openId, "Wechat_EMPTY");
    }

    public ResultMsg loginForRegister(String username, String password) {
        super.register(username, null);
        return super.login(username, null);
    }
}
