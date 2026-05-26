package functional.decorator;

import java.util.function.Function;

public class DecoratorDemo {
    public static void run() {
        System.out.println("\n=== 3. Functional Decorator ===");

        // Окремі функції-декоратори
        Function<String, String> encrypt = text -> "ENCRYPT(" + text + ")";
        Function<String, String> compress = text -> "COMPRESS(" + text + ")";
        Function<String, String> addHash = text -> "HASH[" + text + "]";

        // Композиція (нанизування декораторів)
        Function<String, String> securePipeline = encrypt.andThen(compress).andThen(addHash);

        String rawData = "Паролі: 123456";
        String processedData = securePipeline.apply(rawData);

        System.out.println("Оригінал: " + rawData);
        System.out.println("Після декораторів: " + processedData);
    }
}