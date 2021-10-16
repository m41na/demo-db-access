package works.hop.dbdemo.grid.relation;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class TableNodesTest {

    private final TableNodes graph = new TableNodes();

    @Test
    void testPrintGraph(){
        System.out.println(Graphs.printGraph(graph));
    }

    @Test
    void vertices() {
        List<String> labels = graph.vertices();
        assertThat(labels.size(), Is.is(44));
    }

    @Test
    void neighbours() {
        List<NodeEdge> adjacentToA = graph.neighbours("A");
        assertThat(adjacentToA.size(), Is.is(1));
    }

    @Test
    void inbound() {
        List<NodeEdge> goingTo = graph.inbound("A");
        assertThat(goingTo.size(), Is.is(1));
    }

    @Test
    void outbound() {
        List<NodeEdge> goingTo = graph.outbound("A");
        assertThat(goingTo.size(), Is.is(1));
    }
}