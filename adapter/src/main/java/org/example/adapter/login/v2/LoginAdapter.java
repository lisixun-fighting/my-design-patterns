package org.example.adapter.login.v2;

import org.example.adapter.login.ResultMsg;

public interface LoginAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}
