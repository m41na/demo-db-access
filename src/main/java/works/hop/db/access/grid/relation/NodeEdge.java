package works.hop.db.access.grid.relation;

public class NodeEdge extends Edge<String> {

    public NodeEdge(String src, String dest) {
        super(src, dest);
    }

    public NodeEdge(String src, String dest, int weight) {
        super(src, dest, weight);
    }
}
