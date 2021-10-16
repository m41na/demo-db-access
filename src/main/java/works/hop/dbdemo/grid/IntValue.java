package works.hop.dbdemo.grid;

public class IntValue implements NodeValue<Integer> {

    private Integer value;

    @Override
    public Integer value() {
        return this.value;
    }

    @Override
    public void value(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(Integer o) {
        return this.value.compareTo(o);
    }
}
