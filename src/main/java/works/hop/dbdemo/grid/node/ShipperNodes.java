package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class ShipperNodes {

    public static class ShipperNode<T> extends TableNode<T> {

        public ShipperNode(String label) {
            setLabel(label);
            setSrcTable("shippers");
        }
    }

    public static class ShipperTable extends ShipperNode<Void> {

        public ShipperTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class ShipperId extends ShipperNode<String> {

        public ShipperId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("shipper_id");
        }
    }
}
