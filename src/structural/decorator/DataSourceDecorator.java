package structural.decorator;
public abstract class DataSourceDecorator implements DataSource {
    protected DataSource wrapper;
    public DataSourceDecorator(DataSource w) { this.wrapper = w; }
    public String readData() { return wrapper.readData(); }
}