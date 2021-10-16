package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class CustomerNodes {

    public static class CustomerNode<T> extends TableNode<T> {

        public CustomerNode(String label) {
            setLabel(label);
            setSrcTable("customers");
        }
    }

    public static class CustomerTable extends CustomerNode<Void> {

        public CustomerTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class CustomerId extends CustomerNode<String> {

        public CustomerId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("customer_id");
        }
    }
}
