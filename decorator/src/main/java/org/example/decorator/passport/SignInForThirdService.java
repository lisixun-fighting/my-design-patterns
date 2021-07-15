package org.example.decorator.passport;

public class SignInForThirdService implements ISignInForThirdService {

    private ISignInService service;

    public SignInForThirdService(ISignInService service) {
        this.service = service;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg register(String username, String password) {
        return service.register(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return service.login(username, password);
    }
}
