package structural.proxy;
public class RealDatabase implements Database {
    public void executeQuery(String sql) { System.out.println("Виконання SQL у базі: " + sql); }
}