package works.hop.db.access.grid;

public class CustomerDemographicNodes {

    public static class CustomerDemographicTableNode<T extends Comparable<T>> extends Node<T> {

        public CustomerDemographicTableNode() {
            setSrcTable("customer_customer_demo");
        }
    }

    public static class CustomerId extends CustomerDemographicTableNode<String> {

        public CustomerId() {
            setIsPk(true);
            setColumnName("customer_id");
        }
    }

    public static class CustomerTypeId extends CustomerDemographicTableNode<String> {

        public CustomerTypeId() {
            setIsPk(true);
            setColumnName("customer_type_id");
        }
    }

    public static class CustomerIdFk extends CustomerDemographicTableNode<String> {

        public CustomerIdFk() {
            setIsFk(true);
            setColumnName("customer_id");
            setDestTable("customers");
        }
    }

    public static class CustomerTypeIdFk extends CustomerDemographicTableNode<String> {

        public CustomerTypeIdFk() {
            setIsFk(true);
            setColumnName("customer_type_id");
            setDestTable("customer_demographics");
        }
    }
}
