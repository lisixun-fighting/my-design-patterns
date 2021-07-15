package org.example.jdbc;

import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
public class MyJDBCTemplate implements IJDBCTemplate {

    private Pool connectionPool;

    public MyJDBCTemplate(Pool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public <T> T query(String sql, IRowMapper<T> rowMapper, Object...params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            rs = ps.executeQuery();
            return rowMapper.mapping(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, null);
            connectionPool.releaseConnection(conn);
        }
        return null;
    }

    @Override
    public void update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connectionPool.getConnection();
            assert conn != null;
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, conn);
            connectionPool.releaseConnection(conn);
        }
    }
}
