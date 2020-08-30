package works.hop.db.access.grid;

public class CustomerDemographicNodes {

    public static class CustomerDemographicNode<T extends Comparable<T>> extends TableNode<T> {

        public CustomerDemographicNode() {
            setSrcTable("customer_customer_demo");
        }
    }

    public static class CustomerId extends CustomerDemographicNode<String> {

        public CustomerId() {
            setPk(true);
            setSrcColumn("customer_id");
        }
    }

    public static class CustomerTypeId extends CustomerDemographicNode<String> {

        public CustomerTypeId() {
        	setPk(true);
        	setSrcColumn("customer_type_id");
        }
    }

    public static class CustomerIdFk extends CustomerDemographicNode<String> {

        public CustomerIdFk() {
            setFk(true);
            setSrcColumn("customer_id");
            setDestTable("customers");
            setDestColumn(getSrcColumn());
        }
    }

    public static class CustomerTypeIdFk extends CustomerDemographicNode<String> {

        public CustomerTypeIdFk() {
            setFk(true);
            setSrcColumn("customer_type_id");
            setDestTable("customer_demographics");
            setDestColumn(getSrcColumn());
        }
    }
}
