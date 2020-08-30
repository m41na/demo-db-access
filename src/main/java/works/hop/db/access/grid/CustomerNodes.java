package works.hop.db.access.grid;

public class CustomerNodes {

    public static class CustomerNode<T extends Comparable<T>> extends TableNode<T> {

        public CustomerNode() {
            setSrcTable("customers");
        }
    }

    public static class CustomerId extends CustomerNode<String> {

        public CustomerId() {
            setPk(true);
            setSrcColumn("customer_id");
        }
    }
}
