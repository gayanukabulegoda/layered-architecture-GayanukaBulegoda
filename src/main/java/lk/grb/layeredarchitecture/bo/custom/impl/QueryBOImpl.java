package lk.grb.layeredarchitecture.bo.custom.impl;

import lk.grb.layeredarchitecture.bo.custom.QueryBO;
import lk.grb.layeredarchitecture.dao.DAOFactory;
import lk.grb.layeredarchitecture.dao.custom.QueryDAO;
import lk.grb.layeredarchitecture.dto.CustomerOrderDTO;

import java.sql.SQLException;
import java.util.List;

public class QueryBOImpl implements QueryBO {

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<CustomerOrderDTO> customerOrderDetails() throws SQLException, ClassNotFoundException {
        return queryDAO.customerOrderDetails();
    }
}
