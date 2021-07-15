package org.example.decorator.passport;

public interface ISignInService {

    ResultMsg register(String username, String password);

    ResultMsg login(String username, String password);
}
