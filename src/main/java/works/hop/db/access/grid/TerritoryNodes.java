package works.hop.db.access.grid;

public class TerritoryNodes {

    public static class TerritoryNode<T extends Comparable<T>> extends TableNode<T> {

        public TerritoryNode() {
            setSrcTable("territories");
        }
    }

    public static class TerritoryId extends TerritoryNode<String> {

        public TerritoryId() {
            setPk(true);
            setSrcColumn("territory_id");
        }
    }
    
    public static class TerritoryRegion extends TerritoryNode<String> {

        public TerritoryRegion() {
            setFk(true);
            setSrcColumn("region_to");
            setDestTable("region");
            setDestColumn(getSrcColumn());
        }
    }
}
