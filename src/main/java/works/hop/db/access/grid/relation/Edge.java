package works.hop.db.access.grid.relation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

    private T src;
    private T dest;
    private int weight;

    public Edge(T src, T dest) {
        this.src = src;
        this.dest = dest;
    }

    public Edge(T src, T dest, int weight) {
        this(src, dest);
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge<T> that) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == that) return EQUAL;

        int comparison = this.src.compareTo(that.src);
        if (comparison != EQUAL) return comparison;

        comparison = this.dest.compareTo(that.dest);
        if (comparison != EQUAL) return comparison;

        if (this.weight < that.weight) return BEFORE;
        if (this.weight > that.weight) return AFTER;

        return EQUAL;
    }
}
