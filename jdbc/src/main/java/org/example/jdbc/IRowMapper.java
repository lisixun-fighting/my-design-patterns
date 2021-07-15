package org.example.jdbc;

import java.sql.ResultSet;
import java.util.List;

public interface IRowMapper<T> {

    T mapping(ResultSet rs) throws Exception;

}
