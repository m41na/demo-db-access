package works.hop.dbdemo.grid;

public class StringValue implements NodeValue<String> {

    private String value;

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public void value(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(String o) {
        return this.value.compareTo(o);
    }
}
