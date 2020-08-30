package works.hop.db.access.grid;

public class RegionNodes {

    public static class RegionNode<T extends Comparable<T>> extends TableNode<T> {

        public RegionNode() {
            setSrcTable("region");
        }
    }

    public static class RegionId extends RegionNode<String> {

        public RegionId() {
            setPk(true);
            setSrcColumn("region_id");
        }
    }
}
