package works.hop.db.access.grid;

public class CategoryNodes {

    public static class CategoryTableNode<T extends Comparable<T>> extends Node<T> {

        public CategoryTableNode() {
            setSrcTable("categories");
        }
    }

    public static class CategoryId extends CategoryTableNode<Long> {

        public CategoryId() {
            setIsPk(true);
            setColumnName("category_id");
        }
    }
}
