package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {

    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    boolean exist(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    ResultSet generateNewId() throws SQLException, ClassNotFoundException;
    CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException;
}
