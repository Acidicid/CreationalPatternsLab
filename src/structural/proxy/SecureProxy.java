package structural.proxy;
public class SecureProxy implements Database {
    private RealDatabase db;
    private boolean isHacker;

    public SecureProxy(boolean isHacker) { this.isHacker = isHacker; }

    public void executeQuery(String sql) {
        if (isHacker) {
            System.out.println("БЛОКУВАННЯ! Виявлено спробу несанкціонованого доступу.");
        } else {
            if (db == null) { db = new RealDatabase(); }
            db.executeQuery(sql);
        }
    }
}