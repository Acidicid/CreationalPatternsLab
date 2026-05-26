package functional.strategy;

import java.util.function.Function;

class DataTransmitter {
    // Приймаємо функцію (стратегію) як параметр
    public static void send(String data, Function<String, String> encryptionStrategy) {
        String encrypted = encryptionStrategy.apply(data);
        System.out.println("Відправка даних: " + encrypted);
    }
}

public class StrategyDemo {
    public static void run() {
        System.out.println("=== 1. Functional Strategy ===");
        String data = "Секретні Дані користувачів";

        // Замість створення об'єктів-стратегій просто передаємо лямбда-вирази
        DataTransmitter.send(data, text -> "AES_ENCRYPT(" + text + ")");
        DataTransmitter.send(data, text -> "RSA_ENCRYPT(" + text + ")");
    }
}