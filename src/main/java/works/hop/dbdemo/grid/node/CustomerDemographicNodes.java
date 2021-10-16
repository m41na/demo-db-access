package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class CustomerDemographicNodes {

    public static class CustomerDemographicNode<T> extends TableNode<T> {

        public CustomerDemographicNode(String label) {
            setLabel(label);
            setSrcTable("customer_customer_demo");
        }
    }

    public static class CustomerDemographicTable extends CustomerDemographicNode<Void> {

        public CustomerDemographicTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class CustomerId extends CustomerDemographicNode<String> {

        public CustomerId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("customer_id");
        }
    }

    public static class CustomerTypeId extends CustomerDemographicNode<String> {

        public CustomerTypeId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("customer_type_id");
        }
    }

    public static class CustomerIdFk extends CustomerDemographicNode<String> {

        public CustomerIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("customer_id");
            setDestTable("customers");
            setDestColumn(getSrcColumn());
        }
    }

    public static class CustomerTypeIdFk extends CustomerDemographicNode<String> {

        public CustomerTypeIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("customer_type_id");
            setDestTable("customer_demographics");
            setDestColumn(getSrcColumn());
        }
    }
}
