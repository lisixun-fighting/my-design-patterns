package org.example.staticproxy.dbroute.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;
}
