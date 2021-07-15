package org.example.jdbc;

import org.junit.Test;

import java.util.List;

public class App {

    @Test
    public void test() {
        JDBCUtils<Student> jdbcUtils = new JDBCUtils<>(
                new MyJDBCTemplate(DBConnectionPool.getInstance()), new StudentRowMapper());

//        Student stu = new Student();
//        stu.setName("Linus");
//        stu.setAge(62);
//
//        jdbcUtils.save(stu);

        Student stu = jdbcUtils.getById(2);
        System.out.println(stu);

        List<Student> list = jdbcUtils.getAll();
        System.out.println(list);

        long count = jdbcUtils.count();
        System.out.println(count);
    }

    public static void main(String[] args) {

    }

}
