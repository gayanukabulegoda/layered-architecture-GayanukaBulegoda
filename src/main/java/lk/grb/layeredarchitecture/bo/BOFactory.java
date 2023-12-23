package lk.grb.layeredarchitecture.bo;

import lk.grb.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import lk.grb.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import lk.grb.layeredarchitecture.bo.custom.impl.PlaceOrderBOImpl;
import lk.grb.layeredarchitecture.bo.custom.impl.QueryBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, PLACE_ORDER, QUERY
    }

    public SuperBO getTypes(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            case QUERY:
                return new QueryBOImpl();
            default:
                return null;
        }
    }
}
