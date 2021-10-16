package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class ProductNodes {

    public static class ProductNode<T> extends TableNode<T> {

        public ProductNode(String label) {
            setLabel(label);
            setSrcTable("products");
        }
    }

    public static class ProductTable extends ProductNode<Void> {

        public ProductTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class ProductId extends ProductNode<Long> {

        public ProductId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("product_id");
        }
    }

    public static class ProductCategoryIdFk extends ProductNode<Long> {

        public ProductCategoryIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("category_id");
            setDestTable("categories");
            setDestColumn(getSrcColumn());
        }
    }

    public static class ProductSupplierIdFk extends ProductNode<Long> {

        public ProductSupplierIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("supplier_id");
            setDestTable("suppliers");
            setDestColumn(getSrcColumn());
        }
    }
}
