package works.hop.db.access.grid.node;

import works.hop.db.access.grid.TableNode;

public class OrderNodes {

    public static class OrderNode<T> extends TableNode<T> {

        public OrderNode(String label) {
            setLabel(label);
            setSrcTable("territories");
        }
    }

    public static class OrderTable extends OrderNode<Void> {

        public OrderTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class OrderId extends OrderNode<String> {

        public OrderId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("order_id");
        }
    }

    public static class OrderCustomerIdFk extends OrderNode<String> {

        public OrderCustomerIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("customer_id");
            setDestTable("customers");
            setDestColumn(getSrcColumn());
        }
    }

    public static class OrderEmployeeIdFk extends OrderNode<Long> {

        public OrderEmployeeIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("employee_id");
            setDestTable("employees");
            setDestColumn(getSrcColumn());
        }
    }

    public static class OrderShipViaFk extends OrderNode<Long> {

        public OrderShipViaFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("ship_via");
            setDestTable("shippers");
            setDestColumn("shipper_id");
        }
    }
}
