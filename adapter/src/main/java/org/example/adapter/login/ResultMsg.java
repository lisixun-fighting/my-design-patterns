package org.example.adapter.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResultMsg {

    private int code;
    private String msg;
    private Object data;

}
