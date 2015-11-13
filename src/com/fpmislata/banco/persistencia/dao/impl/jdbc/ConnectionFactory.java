package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import java.sql.Connection;

public interface ConnectionFactory {
    public Connection getConnection();
    
    public void close(Connection connection);
}
