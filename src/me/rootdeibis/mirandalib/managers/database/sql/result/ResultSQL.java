package me.rootdeibis.mirandalib.managers.database.sql.result;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("all")
public class ResultSQL  {

    private final ResultSet resultSet;

    public ResultSQL(ResultSet resultSet) {

        this.resultSet = resultSet;
    }

    public <T> T find(T type, String key) {
        try {
            return (T) this.resultSet.getObject(key);
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }
    
}
