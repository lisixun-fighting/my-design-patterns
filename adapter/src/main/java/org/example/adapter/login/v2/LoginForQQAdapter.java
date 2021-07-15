package org.example.adapter.login.v2;

import org.example.adapter.login.ResultMsg;

public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return new ResultMsg(200, "Login For QQ", null);
    }
}
