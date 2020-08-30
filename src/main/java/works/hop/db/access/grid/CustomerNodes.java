package works.hop.db.access.grid;

public class CustomerNodes {

    public static class CustomerTableNode<T extends Comparable<T>> extends Node<T> {

        public CustomerTableNode() {
            setSrcTable("customers");
        }
    }

    public static class CustomerId extends CustomerTableNode<String> {

        public CustomerId() {
            setIsPk(true);
            setColumnName("customer_id");
        }
    }
}
