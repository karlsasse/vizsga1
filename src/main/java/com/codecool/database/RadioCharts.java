package com.codecool.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class RadioCharts {
    RadioCharts(String url, String user, String password) {
        connectToDataBase(url, user, password);
    }

    public String getMostPlayedSong() {
        return "";
    }

    public String getMostActiveArtist() {
        return "";
    }

    private void connectToDataBase(String url, String user, String password) {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.serverName +
                            ":" + this.portNumber + "/",
                    connectionProps);
        } else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbName +
                            ";create=true",
                    connectionProps);
        }
        System.out.println("Connected to database");
    }
}
