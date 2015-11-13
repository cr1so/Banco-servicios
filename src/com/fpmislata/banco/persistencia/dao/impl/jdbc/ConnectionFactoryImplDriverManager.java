package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryImplDriverManager implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        
        try {
            Connection connection;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
