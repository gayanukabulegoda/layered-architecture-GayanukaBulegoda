package lk.grb.layeredarchitecture.dao.custom;

import lk.grb.layeredarchitecture.dao.CrudDAO;
import lk.grb.layeredarchitecture.entity.Order;

import java.sql.*;

public interface OrderDAO extends CrudDAO<Order> {

    ResultSet generateNewId() throws SQLException, ClassNotFoundException;

    boolean save(Order entity) throws SQLException, ClassNotFoundException;

    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
}
