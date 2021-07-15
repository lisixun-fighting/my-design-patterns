package org.example.decorator.passport;

public interface ISignInForThirdService extends ISignInService {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

}
