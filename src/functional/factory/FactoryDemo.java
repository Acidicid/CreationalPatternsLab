package functional.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface Server { void start(); }
class WebServer implements Server { public void start() { System.out.println("Web-сервер захисту запущено."); } }
class DatabaseServer implements Server { public void start() { System.out.println("DB-сервер логів запущено."); } }

class ServerFactory {
    // Зберігаємо не самі об'єкти, а "інструкції" для їх створення
    private static final Map<String, Supplier<Server>> map = new HashMap<>();

    static {
        map.put("web", WebServer::new);
        map.put("db", DatabaseServer::new);
    }

    public static Server createServer(String type) {
        Supplier<Server> serverSupplier = map.get(type.toLowerCase());
        if (serverSupplier != null) return serverSupplier.get();
        throw new IllegalArgumentException("Невідомий тип сервера");
    }
}

public class FactoryDemo {
    public static void run() {
        System.out.println("\n=== 2. Functional Factory Method ===");
        Server web = ServerFactory.createServer("web");
        web.start();

        Server db = ServerFactory.createServer("db");
        db.start();
    }
}