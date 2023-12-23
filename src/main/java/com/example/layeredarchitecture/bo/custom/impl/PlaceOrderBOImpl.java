package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.util.TransactionConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/

        boolean isOrderSaved;
        boolean isOrderDetailSaved = false;
        boolean isItemUpdated = false;

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderDate(orderDate);
        orderDTO.setCustomerId(customerId);

        orderDAO.selectOrderId(orderId);

        TransactionConnection.getConnection().setAutoCommit(false);
        isOrderSaved = orderDAO.save(orderDTO);

        for (OrderDetailDTO detail : orderDetails) {
            isOrderDetailSaved = orderDetailDAO.save(orderId, detail);

            //Search & Update Item
            ItemDTO item = findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            isItemUpdated = itemDAO.update(item);
        }

        if (isOrderSaved && isOrderDetailSaved && isItemUpdated) {
            TransactionConnection.getConnection().commit();
            TransactionConnection.getConnection().setAutoCommit(true);
            return true;
        }
        return false;
    }

    public ItemDTO findItem(String code) {
        try {
            ItemDTO dto = itemDAO.search(code);

            return new ItemDTO(code,
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQtyOnHand()
            );

        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(newValue);
        CustomerDTO customerDTO = new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress()
        );
        return customerDTO;
    }

    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(newItemCode);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers) {

        }
       // return customerDAO.getAll();
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}
