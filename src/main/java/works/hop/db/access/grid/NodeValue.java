package works.hop.db.access.grid;

public interface NodeValue<T> extends Comparable<T> {

    T value();

    void value(T value);
}
