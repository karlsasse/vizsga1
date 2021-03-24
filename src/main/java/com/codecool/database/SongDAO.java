package com.codecool.database;

import java.util.List;

public interface SongDAO {
    GameState get(int id);
    List<GameState> getAll();
}
