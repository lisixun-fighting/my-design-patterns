package org.example.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentRowMapper implements IRowMapper<List<Student>> {

    @Override
    public List<Student> mapping(ResultSet rs) throws Exception {
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            list.add(new Student(id, name, age));
        }
        return list;
    }
}
