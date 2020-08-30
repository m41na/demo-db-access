package works.hop.db.access.grid;

public class OrderNodes {

    public static class OrderNode<T extends Comparable<T>> extends TableNode<T> {

        public OrderNode() {
            setSrcTable("territories");
        }
    }

    public static class OrderId extends OrderNode<String> {

        public OrderId() {
            setPk(true);
            setSrcColumn("order_id");
        }
    }
    
    public static class OrderCustomer extends OrderNode<String> {

        public OrderCustomer() {
            setFk(true);
            setSrcColumn("customer_id");
            setDestTable("customers");
            setDestColumn(getSrcColumn());
        }
    }
    
    public static class OrderEmployee extends OrderNode<Long> {

        public OrderEmployee() {
            setFk(true);
            setSrcColumn("employee_id");
            setDestTable("employees");
            setDestColumn(getSrcColumn());
        }
    }
    
    public static class OrderShipper extends OrderNode<Long> {

        public OrderShipper() {
            setFk(true);
            setSrcColumn("ship_via");
            setDestTable("shippers");
            setDestColumn("shipper_id");
        }
    }
}
