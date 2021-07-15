package org.example.adapter.login.v2;

import org.example.adapter.login.ResultMsg;
import org.example.adapter.login.SignInService;

public class PassportForThirdAdapter extends SignInService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.getConstructor().newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(key, adapter);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
