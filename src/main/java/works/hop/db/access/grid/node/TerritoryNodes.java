package works.hop.db.access.grid.node;

import works.hop.db.access.grid.TableNode;

public class TerritoryNodes {

    public static class TerritoryNode<T> extends TableNode<T> {

        public TerritoryNode(String label) {
            setLabel(label);
            setSrcTable("territories");
        }
    }

    public static class TerritoryTable extends TerritoryNode<Void> {

        public TerritoryTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class TerritoryId extends TerritoryNode<String> {

        public TerritoryId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("territory_id");
        }
    }

    public static class TerritoryRegionIdFk extends TerritoryNode<String> {

        public TerritoryRegionIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("region_to");
            setDestTable("region");
            setDestColumn(getSrcColumn());
        }
    }
}
