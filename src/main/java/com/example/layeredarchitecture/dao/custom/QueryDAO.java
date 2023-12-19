package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomerOrderDTO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO {
    List<CustomerOrderDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
