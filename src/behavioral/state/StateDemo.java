package behavioral.state;

interface ServerState { void handleRequest(); }

class OnlineState implements ServerState {
    public void handleRequest() { System.out.println("Сервер обробляє запит."); }
}

class MaintenanceState implements ServerState {
    public void handleRequest() { System.out.println("Помилка 503: Сервер на обслуговуванні."); }
}

class ServerContext {
    private ServerState state = new OnlineState();
    public void setState(ServerState state) { this.state = state; }
    public void request() { state.handleRequest(); }
}

public class StateDemo {
    public static void run() {
        System.out.println("\n=== 7. State ===");
        ServerContext context = new ServerContext();
        context.request();
        context.setState(new MaintenanceState());
        context.request();
    }
}