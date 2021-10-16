package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class OrderDetailNodes {

    public static class OrderDetailNode<T> extends TableNode<T> {

        public OrderDetailNode(String label) {
            setLabel(label);
            setSrcTable("territories");
        }
    }

    public static class OrderDetailTable extends OrderDetailNode<Void> {

        public OrderDetailTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class OrderDetailId extends OrderDetailNode<String> {

        public OrderDetailId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("order_id");
        }
    }

    public static class OrderDetailProductId extends OrderDetailNode<String> {

        public OrderDetailProductId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("product_id");
        }
    }

    public static class OrderDetailIdFk extends OrderDetailNode<String> {

        public OrderDetailIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("order_id");
            setDestTable("orders");
            setDestColumn(getSrcColumn());
        }
    }

    public static class OrderDetailProductIdFk extends OrderDetailNode<Long> {

        public OrderDetailProductIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("product_id");
            setDestTable("products");
            setDestColumn(getSrcColumn());
        }
    }
}
