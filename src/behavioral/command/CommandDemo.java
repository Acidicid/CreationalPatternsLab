package behavioral.command;

interface Command { void execute(); }

class Server {
    public void start() { System.out.println("Сервер запущено."); }
}

class StartServerCommand implements Command {
    private Server server;
    public StartServerCommand(Server s) { this.server = s; }
    public void execute() { server.start(); }
}

public class CommandDemo {
    public static void run() {
        System.out.println("\n=== 2. Command ===");
        Server server = new Server();
        Command start = new StartServerCommand(server);
        start.execute();
    }
}