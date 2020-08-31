package works.hop.db.access.grid.node;

import works.hop.db.access.grid.TableNode;

public class DemographicNodes {

    public static class DemographicNode<T> extends TableNode<T> {

        public DemographicNode(String label) {
            setLabel(label);
            setSrcTable("customer_demographics");
        }
    }

    public static class DemographicTable extends DemographicNode<Void> {

        public DemographicTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class CustomerTypeId extends DemographicNode<String> {

        public CustomerTypeId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("customer_type_id");
        }
    }
}
