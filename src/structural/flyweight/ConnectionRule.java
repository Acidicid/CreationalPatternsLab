package structural.flyweight;
public class ConnectionRule {
    private String protocolType; // Спільний стан
    public ConnectionRule(String type) { this.protocolType = type; }

    public void applyRule(String targetIP) {
        System.out.println("Правило [" + protocolType + "] застосовано до IP: " + targetIP);
    }
}