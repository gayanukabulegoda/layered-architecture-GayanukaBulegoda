package com.example.layeredarchitecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO {

    ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
}
