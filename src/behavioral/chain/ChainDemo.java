package behavioral.chain;

abstract class SecurityHandler {
    protected SecurityHandler next;
    public void setNext(SecurityHandler next) { this.next = next; }
    public abstract boolean check(String request);
}

class IPCheckHandler extends SecurityHandler {
    public boolean check(String request) {
        System.out.println("Перевірка IP-адреси...");
        if (request.contains("Banned_IP")) return false;
        return next == null || next.check(request);
    }
}

class RoleCheckHandler extends SecurityHandler {
    public boolean check(String request) {
        System.out.println("Перевірка прав доступу...");
        if (!request.contains("Admin")) return false;
        return next == null || next.check(request);
    }
}

public class ChainDemo {
    public static void run() {
        System.out.println("=== 1. Chain of Responsibility ===");
        SecurityHandler ipCheck = new IPCheckHandler();
        SecurityHandler roleCheck = new RoleCheckHandler();
        ipCheck.setNext(roleCheck);
        System.out.println("Доступ надано: " + ipCheck.check("User_Admin"));
    }
}