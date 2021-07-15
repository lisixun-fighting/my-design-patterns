package org.example.template.jdbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private String username;
    private String password;
    private String nickName;
    private int age;
    private String addr;

}
