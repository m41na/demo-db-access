package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class StateAbbrNodes {

    public static class StateAbbrNode<T> extends TableNode<T> {

        public StateAbbrNode(String label) {
            setLabel(label);
            setSrcTable("us_states");
        }
    }

    public static class StateAbbrTable extends StateAbbrNode<Void> {

        public StateAbbrTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class StateAbbrId extends StateAbbrNode<String> {

        public StateAbbrId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("state_id");
        }
    }
}
