package works.hop.db.access.grid;

public class CategoryNodes {

    public static class CategoryNode<T extends Comparable<T>> extends TableNode<T> {

        public CategoryNode() {
        	setSrcTable("categories");
        }
    }

    public static class CategoryId extends CategoryNode<Long> {

        public CategoryId() {
            setPk(true);
            setSrcColumn("category_id");
        }
    }
}
