package works.hop.db.access.grid.node;

import works.hop.db.access.grid.TableNode;

public class SupplierNodes {

    public static class SupplierNode<T> extends TableNode<T> {

        public SupplierNode(String label) {
            setLabel(label);
            setSrcTable("suppliers");
        }
    }

    public static class SupplierTable extends SupplierNode<Void> {

        public SupplierTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class SupplierId extends SupplierNode<String> {

        public SupplierId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("supplier_id");
        }
    }
}
