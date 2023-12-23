package lk.grb.layeredarchitecture.dao.custom;

import lk.grb.layeredarchitecture.dao.SuperDAO;
import lk.grb.layeredarchitecture.dto.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<CustomerOrderDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
