package lk.grb.layeredarchitecture.bo.custom;

import lk.grb.layeredarchitecture.bo.SuperBO;
import lk.grb.layeredarchitecture.dto.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface QueryBO extends SuperBO {

    List<CustomerOrderDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
