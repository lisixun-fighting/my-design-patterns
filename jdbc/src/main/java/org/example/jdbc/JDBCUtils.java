package org.example.jdbc;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@AllArgsConstructor
@Setter
public class JDBCUtils<T> {

    private IJDBCTemplate jdbcTemplate;

    private IRowMapper<List<T>> rowMapper;

    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void save(Object...params) {
        String sql = "INSERT INTO student (name, age) VALUES (?,?)";
        jdbcTemplate.update(sql, params[0], params[1]);
    }

    public void update(Object...params) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, params[0], params[1], params[2]);
    }

    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public T getById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        List<T> studentList = jdbcTemplate.query(sql, rowMapper, id);
        return studentList.get(0);
    }

    public List<T> getAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public long count() {
        String sql = "SELECT COUNT(*) as 'total' FROM student";
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next())
                return rs.getLong("total");
            return null;
        });
    }
}
