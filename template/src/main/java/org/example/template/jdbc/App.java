package org.example.template.jdbc;

import javax.sql.DataSource;
import java.util.List;

public class App {
    public static void main(String[] args) {
        MemberDao memberDao = (MemberDao) DaoFactory.getDao(MemberDao.class);
        List<Member> members = memberDao.selectAll();
        System.out.println(members);

    }
}
