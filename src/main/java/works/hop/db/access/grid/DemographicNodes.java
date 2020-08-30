package works.hop.db.access.grid;

public class DemographicNodes {

    public static class DemographicNode<T extends Comparable<T>> extends TableNode<T> {

        public DemographicNode() {
            setSrcTable("customer_demographics");
        }
    }

    public static class CustomerTypeId extends DemographicNode<String> {

        public CustomerTypeId() {
        	setPk(true);
        	setSrcColumn("customer_type_id");
        }
    }
}
