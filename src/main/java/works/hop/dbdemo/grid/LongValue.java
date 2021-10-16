package works.hop.dbdemo.grid;

public class LongValue implements NodeValue<Long> {

    private Long value;

    @Override
    public Long value() {
        return this.value;
    }

    @Override
    public void value(Long value) {
        this.value = value;
    }

    @Override
    public int compareTo(Long o) {
        return this.value.compareTo(o);
    }
}
