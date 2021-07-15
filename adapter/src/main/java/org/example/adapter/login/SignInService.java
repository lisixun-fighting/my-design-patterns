package org.example.adapter.login;

import java.sql.ResultSet;

public class SignInService {

    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "register successfully", new Member());
    }

    public ResultMsg login(String username, String password) {
        return new ResultMsg(200, "login with username and password", null);
    }

}
