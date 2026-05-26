package behavioral.template;

abstract class SecurityAudit {
    public final void conductAudit() {
        authenticate();
        scanVulnerabilities();
        generateReport();
    }
    private void authenticate() { System.out.println("Авторизація аудитора..."); }
    protected abstract void scanVulnerabilities();
    private void generateReport() { System.out.println("Звіт згенеровано.\n"); }
}

class WindowsAudit extends SecurityAudit {
    protected void scanVulnerabilities() { System.out.println("Сканування реєстру та служб Windows..."); }
}

public class TemplateDemo {
    public static void run() {
        System.out.println("\n=== 9. Template Method ===");
        SecurityAudit audit = new WindowsAudit();
        audit.conductAudit();
    }
}