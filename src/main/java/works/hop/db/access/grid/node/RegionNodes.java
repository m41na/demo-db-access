package works.hop.db.access.grid.node;

import works.hop.db.access.grid.TableNode;

public class RegionNodes {

    public static class RegionNode<T> extends TableNode<T> {

        public RegionNode(String label) {
            setLabel(label);
            setSrcTable("region");
        }
    }

    public static class RegionTable extends RegionNode<Void> {

        public RegionTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class RegionId extends RegionNode<String> {

        public RegionId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("region_id");
        }
    }
}
