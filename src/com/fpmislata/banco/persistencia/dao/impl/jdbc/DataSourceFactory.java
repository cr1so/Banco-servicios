package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import javax.sql.DataSource;

public interface DataSourceFactory {
    public DataSource getDataSource();
}
