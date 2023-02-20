package me.rootdeibis.mirandalib.managers.database.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import me.rootdeibis.mirandalib.managers.database.sql.result.ResultSQL;

public abstract class DatabaseSQL {


    public abstract Connection createConnection();
    


    public ResultSQL query(String q, String... params) {
        Connection conn = this.createConnection();

       try {    

    
        PreparedStatement statement = conn.prepareStatement(q);

        int param_i = 0;
        while(param_i < params.length) {

            statement.setString(param_i, params[param_i]);

            ++param_i;
        }

        return new ResultSQL( statement.executeQuery());
        
       } catch (Exception e) {

         e.printStackTrace();
         return null;
       }


    }
    
}
