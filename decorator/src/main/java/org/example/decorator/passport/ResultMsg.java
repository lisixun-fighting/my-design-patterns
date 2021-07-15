package org.example.decorator.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ResultMsg {

    private int code;
    private String msg;
    private Object data;

}
