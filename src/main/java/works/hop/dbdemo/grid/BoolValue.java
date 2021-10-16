package works.hop.dbdemo.grid;

public class BoolValue implements NodeValue<Boolean> {

    private Boolean value;

    @Override
    public Boolean value() {
        return this.value;
    }

    @Override
    public void value(Boolean value) {
        this.value = value;
    }

    @Override
    public int compareTo(Boolean o) {
        return this.value.compareTo(o);
    }
}
