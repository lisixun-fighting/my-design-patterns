package org.example.template.jdbc;

import javax.sql.DataSource;
import java.util.List;

public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> selectAll() {
        String sql = "SELECT * FROM student";
        return executeQuery(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setUsername(rs.getString("name"));
            member.setAge(rs.getInt("age"));
            return member;
        }, new Object[0]);
    }

}
