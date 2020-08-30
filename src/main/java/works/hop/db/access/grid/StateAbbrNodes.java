package works.hop.db.access.grid;

public class StateAbbrNodes {

    public static class StateAbbrNode<T extends Comparable<T>> extends TableNode<T> {

        public StateAbbrNode() {
            setSrcTable("us_states");
        }
    }

    public static class StateAbbrId extends StateAbbrNode<String> {

        public StateAbbrId() {
            setPk(true);
            setSrcColumn("state_id");
        }
    }
}
