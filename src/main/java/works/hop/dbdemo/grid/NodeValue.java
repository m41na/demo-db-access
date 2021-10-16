package works.hop.dbdemo.grid;

public interface NodeValue<T> extends Comparable<T> {

    T value();

    void value(T value);
}
