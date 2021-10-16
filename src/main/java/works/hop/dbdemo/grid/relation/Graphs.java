package works.hop.dbdemo.grid.relation;

public class Graphs {

    private Graphs() {
        throw new Error("New instance not allowed");
    }

    public static String printGraph(TableNodes graph) {
        StringBuilder builder = new StringBuilder();
        for (String vertex : graph.vertices()) {
            builder.append(vertex).append(": ");
            for (NodeEdge edge : graph.neighbours(vertex)) {
                builder.append("(").append(edge.getSrc()).append(" --> ").append(edge.getDest()).append(")\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
