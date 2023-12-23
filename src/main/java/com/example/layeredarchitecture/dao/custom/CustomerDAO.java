package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
}
