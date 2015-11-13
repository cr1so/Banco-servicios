package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Override
    public Connection getConnection() {

        try {
            InitialContext initCtx = new InitialContext();;
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/banco");
            
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
