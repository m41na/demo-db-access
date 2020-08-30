package works.hop.db.access.grid;

public class OrderDetailNodes {

    public static class OrderDetailNode<T extends Comparable<T>> extends TableNode<T> {

        public OrderDetailNode() {
            setSrcTable("territories");
        }
    }

    public static class OrderDetailId extends OrderDetailNode<String> {

        public OrderDetailId() {
            setPk(true);
            setSrcColumn("order_id");
        }
    }
    
    public static class OrderDetailProductId extends OrderDetailNode<String> {

        public OrderDetailProductId() {
            setPk(true);
            setSrcColumn("product_id");
        }
    }
    
    public static class OrderDetailIdFk extends OrderDetailNode<String> {

        public OrderDetailIdFk() {
            setFk(true);
            setSrcColumn("order_id");
            setDestTable("orders");
            setDestColumn(getSrcColumn());
        }
    }
    
    public static class OrderDetailProductIdFk extends OrderDetailNode<Long> {

        public OrderDetailProductIdFk() {
            setFk(true);
            setSrcColumn("product_id");
            setDestTable("products");
            setDestColumn(getSrcColumn());
        }
    }
    
    public static class OrderDetailShipper extends OrderDetailNode<Long> {

        public OrderDetailShipper() {
            setFk(true);
            setSrcColumn("ship_via");
            setDestTable("shippers");
            setDestColumn("shipper_id");
        }
    }
}
