package works.hop.db.access.grid;

public class SupplierNodes {

    public static class SupplierNode<T extends Comparable<T>> extends TableNode<T> {

        public SupplierNode() {
            setSrcTable("suppliers");
        }
    }

    public static class SupplierId extends SupplierNode<String> {

        public SupplierId() {
            setPk(true);
            setSrcColumn("supplier_id");
        }
    }
}
