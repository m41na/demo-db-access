package works.hop.db.access.grid;

public class ProductNodes {

	public static class ProductNode<T extends Comparable<T>> extends TableNode<T> {

		public ProductNode() {
			setSrcTable("products");
		}
	}

	public static class ProductId extends ProductNode<Long> {

		public ProductId() {
			setPk(true);
			setSrcColumn("product_id");
		}
	}

	public static class ProductCategory extends ProductNode<Long> {

		public ProductCategory() {
			setFk(true);
			setSrcColumn("category_id");
			setDestTable("categories");
			setDestColumn(getSrcColumn());
		}
	}

	public static class ProductSupplier extends ProductNode<Long> {

		public ProductSupplier() {
			setFk(true);
			setSrcColumn("supplier_id");
			setDestTable("suppliers");
			setDestColumn(getSrcColumn());
		}
	}
}
