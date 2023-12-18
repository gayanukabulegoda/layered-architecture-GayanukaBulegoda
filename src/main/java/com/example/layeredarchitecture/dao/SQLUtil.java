package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {

    public void execute(String sql, Object... arg) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < arg.length; i++) {
            pstm.setObject((i+1), arg[i]);
        }

        if (sql.startsWith("SELECT") || sql.startsWith("select")) {
            pstm.executeQuery();
        }
        else {
            pstm.executeUpdate();
        }
    }
}
