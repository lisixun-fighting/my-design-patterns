package org.example.template.jdbc;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
public class JdbcTemplate {

    private DataSource dataSource;

    public <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object[] values) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstm = createPrepareStatement(conn, sql);
            ResultSet rs = executeQuery(pstm, values);
            List<T> result = paresResultSet(rs, rowMapper);
            closeResultSet(rs);
            closeStatement(pstm);
            closeConnection(conn);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected final void closeConnection(Connection conn) throws Exception {
        conn.close();
    }

    protected final void closeStatement(PreparedStatement pstm) throws Exception {
        pstm.close();
    }

    protected final void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    protected <T> List<T> paresResultSet(ResultSet rs, RowMapper<T> rowMapper) throws Exception {
        List<T> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement pstm, Object[] params) throws Exception {
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1, params[i]);
        }
        return pstm.executeQuery();
    }

    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public final Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
