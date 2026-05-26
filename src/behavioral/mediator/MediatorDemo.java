package behavioral.mediator;

interface NetworkMediator { void sendMessage(String msg, Node sender); }

abstract class Node {
    protected NetworkMediator mediator;
    public Node(NetworkMediator m) { this.mediator = m; }
    public abstract void send(String msg);
    public abstract void receive(String msg);
}

class WebServer extends Node {
    public WebServer(NetworkMediator m) { super(m); }
    public void send(String msg) { mediator.sendMessage(msg, this); }
    public void receive(String msg) { System.out.println("WebServer отримав: " + msg); }
}

class DatabaseNode extends Node {
    public DatabaseNode(NetworkMediator m) { super(m); }
    public void send(String msg) { mediator.sendMessage(msg, this); }
    public void receive(String msg) { System.out.println("Database отримала: " + msg); }
}

class SwitchMediator implements NetworkMediator {
    public WebServer web;
    public DatabaseNode db;
    public void sendMessage(String msg, Node sender) {
        if (sender == web) db.receive(msg);
        else web.receive(msg);
    }
}

public class MediatorDemo {
    public static void run() {
        System.out.println("\n=== 4. Mediator ===");
        SwitchMediator switchMed = new SwitchMediator();
        WebServer web = new WebServer(switchMed);
        DatabaseNode db = new DatabaseNode(switchMed);
        switchMed.web = web; switchMed.db = db;
        web.send("Запит на дані користувача");
    }
}