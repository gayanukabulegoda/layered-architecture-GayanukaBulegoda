package lk.grb.layeredarchitecture.bo.custom;

import lk.grb.layeredarchitecture.bo.SuperBO;
import lk.grb.layeredarchitecture.dto.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
    ResultSet generateNewItemId() throws SQLException, ClassNotFoundException;
}
