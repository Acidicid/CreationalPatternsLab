package behavioral.visitor;

interface ScannerVisitor {
    void visit(FileServer fs);
    void visit(Router r);
}

interface NetworkElement { void accept(ScannerVisitor visitor); }

class FileServer implements NetworkElement {
    public void accept(ScannerVisitor visitor) { visitor.visit(this); }
}

class Router implements NetworkElement {
    public void accept(ScannerVisitor visitor) { visitor.visit(this); }
}

class AntivirusScanner implements ScannerVisitor {
    public void visit(FileServer fs) { System.out.println("Антивірус сканує файли."); }
    public void visit(Router r) { System.out.println("Антивірус перевіряє маршрутизатор."); }
}

public class VisitorDemo {
    public static void run() {
        System.out.println("=== 10. Visitor ===");
        NetworkElement fileServer = new FileServer();
        ScannerVisitor scanner = new AntivirusScanner();
        fileServer.accept(scanner);
    }
}