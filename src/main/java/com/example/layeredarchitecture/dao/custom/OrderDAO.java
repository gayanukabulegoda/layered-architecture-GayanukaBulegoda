package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dto.OrderDTO;

import java.sql.*;

public interface OrderDAO extends CrudDAO<OrderDTO> {

    ResultSet generateNewId() throws SQLException, ClassNotFoundException;

    boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
}
