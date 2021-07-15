package org.example.decorator.passport;

public class SignInService implements ISignInService {
    @Override
    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "register with u and p", new Member());
    }

    @Override
    public ResultMsg login(String username, String password) {
        return new ResultMsg(200, "login with u and p", null);
    }
}
