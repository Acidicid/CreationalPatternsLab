package behavioral.memento;

class Snapshot {
    private final String savedRules;
    public Snapshot(String rules) { this.savedRules = rules; }
    public String getSavedRules() { return savedRules; }
}

class FirewallConfig {
    private String rules;
    public void setRules(String rules) { this.rules = rules; }
    public String getRules() { return rules; }

    public Snapshot save() { return new Snapshot(rules); }
    public void restore(Snapshot s) { this.rules = s.getSavedRules(); }
}

public class MementoDemo {
    public static void run() {
        System.out.println("\n=== 5. Memento ===");
        FirewallConfig config = new FirewallConfig();
        config.setRules("Блокувати Port 80");
        Snapshot backup = config.save();
        config.setRules("Дозволити все (Помилка)");
        config.restore(backup);
        System.out.println("Відновлені правила: " + config.getRules());
    }
}