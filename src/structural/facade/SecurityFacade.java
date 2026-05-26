package structural.facade;
public class SecurityFacade {
    private Firewall firewall = new Firewall();
    private IntrusionDetection ids = new IntrusionDetection();

    public void lockdown() {
        System.out.println("Ініціалізація протоколу безпеки...");
        firewall.enable();
        ids.start();
        System.out.println("Систему повністю захищено!");
    }
}