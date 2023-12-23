package lk.grb.layeredarchitecture.dao.custom;

import lk.grb.layeredarchitecture.dao.CrudDAO;
import lk.grb.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetail> {

    boolean save(String orderId, OrderDetail detail) throws SQLException, ClassNotFoundException;
}
