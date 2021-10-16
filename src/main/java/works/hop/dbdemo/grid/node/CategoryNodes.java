package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class CategoryNodes {

    public static class CategoryNode<T> extends TableNode<T> {

        public CategoryNode(String label) {
            setLabel(label);
            setSrcTable("categories");
        }
    }

    public static class CategoryTable extends CategoryNode<Void> {

        public CategoryTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class CategoryId extends CategoryNode<Long> {

        public CategoryId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("category_id");
        }
    }
}
