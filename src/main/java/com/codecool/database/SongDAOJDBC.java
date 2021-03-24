package com.codecool.database;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class SongDAOJDBC extends DAOJDBC implements SongDAO {

    public SongDAOJDBC(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    public GameState get(int id) {
        String query = "select * from music_broadcast where id=" + id;
        String state = "";
        try (Connection conn = dataSource.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            state = rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new GameState(state.split(",")[0], new Date(Long.parseLong(state.split(",")[1])));
    }
}
