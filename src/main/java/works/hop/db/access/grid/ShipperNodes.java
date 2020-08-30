package works.hop.db.access.grid;

public class ShipperNodes {

    public static class ShipperNode<T extends Comparable<T>> extends TableNode<T> {

        public ShipperNode() {
            setSrcTable("shippers");
        }
    }

    public static class ShipperId extends ShipperNode<String> {

        public ShipperId() {
            setPk(true);
            setSrcColumn("shipper_id");
        }
    }
}
