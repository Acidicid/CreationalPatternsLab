package functional.executearound;

import java.util.function.Consumer;

class SecureResource {
    private SecureResource() { System.out.println("Відкриття захищеного тунелю VPN..."); }
    private void close() { System.out.println("Закриття тунелю та очищення слідів."); }

    public void executeOperation(String task) { System.out.println("Виконання в тунелі: " + task); }

    // Метод Навколишнього виконання
    public static void use(Consumer<SecureResource> block) {
        SecureResource resource = new SecureResource(); // SETUP (ДО)
        try {
            block.accept(resource); // ВИКОНАННЯ ОСНОВНОЇ ЛОГІКИ
        } finally {
            resource.close(); // TEARDOWN (ПІСЛЯ)
        }
    }
}

public class ExecuteAroundDemo {
    public static void run() {
        System.out.println("\n=== 4. Execute Around ===");

        SecureResource.use(resource -> {
            resource.executeOperation("Завантаження вірусних сигнатур");
            resource.executeOperation("Синхронізація ключів");
            // Навіть якщо тут виникне помилка, метод close() гарантовано виконається
        });
    }
}