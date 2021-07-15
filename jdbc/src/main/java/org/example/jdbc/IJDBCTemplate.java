package org.example.jdbc;

import java.util.List;

public interface IJDBCTemplate {

    <T> T query(String sql, IRowMapper<T> mapper, Object...params);

    void update(String sql, Object...params);
}
