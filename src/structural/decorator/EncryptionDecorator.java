package structural.decorator;
public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource w) { super(w); }
    public String readData() { return "AES_ENCRYPTED( " + super.readData() + " )"; }
}