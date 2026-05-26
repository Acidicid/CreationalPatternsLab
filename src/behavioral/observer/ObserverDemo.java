package behavioral.observer;
import java.util.ArrayList;
import java.util.List;

interface Observer { void update(String event); }

class IntrusionSystem {
    private List<Observer> admins = new ArrayList<>();
    public void addObserver(Observer o) { admins.add(o); }
    public void detectThreat(String threat) {
        System.out.println("Виявлено загрозу: " + threat);
        for (Observer admin : admins) { admin.update(threat); }
    }
}

class AdminAlert implements Observer {
    private String name;
    public AdminAlert(String name) { this.name = name; }
    public void update(String event) { System.out.println("Адмін " + name + " отримав тривогу: " + event); }
}

public class ObserverDemo {
    public static void run() {
        System.out.println("\n=== 6. Observer ===");
        IntrusionSystem ids = new IntrusionSystem();
        ids.addObserver(new AdminAlert("Іван"));
        ids.detectThreat("Brute-force атака!");
    }
}