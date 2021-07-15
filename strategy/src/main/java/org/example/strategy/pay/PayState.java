package org.example.strategy.pay;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PayState {
    private int code;
    private Object data;
    private String msg;
}
