package com.codecool.database;

import javax.sql.DataSource;

public abstract class DAOJDBC {

    protected DataSource dataSource;
    public DAOJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
