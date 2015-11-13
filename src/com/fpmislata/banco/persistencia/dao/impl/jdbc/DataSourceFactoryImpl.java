package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDataSource() {
        DataSource dataSource;
        try {
            InitialContext initCtx = new InitialContext();;
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            dataSource = (DataSource) envCtx.lookup("jdbc/banco");
        } catch (NamingException ex) {
            dataSource = null;
            throw new RuntimeException(ex);
        }
        return dataSource;
    }

}
