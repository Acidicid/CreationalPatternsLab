package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainLambda {

    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №5: Лямбда-вирази та Stream API ===");

        // 1. Фільтрація непарних чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("1. Непарні числа: " + filterOddNumbers(numbers));

        // 2. Середнє значення
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        System.out.println("2. Середнє значення: " + findAverage(doubles));

        // 3. Сортування за алфавітом
        List<String> words = Arrays.asList("Яблуко", "Банан", "Апельсин", "Груша");
        System.out.println("3. За алфавітом: " + sortAlphabetically(words));

        // 4. Сума парних чисел
        System.out.println("4. Сума парних чисел: " + sumOfEvens(numbers));

        // 5. Факторіал числа
        int n = 5;
        System.out.println("5. Факторіал " + n + ": " + calculateFactorial(n));

        // 6. Сума та добуток елементів
        long[] sumAndProduct = calculateSumAndProduct(numbers);
        System.out.println("6. Сума: " + sumAndProduct[0] + ", Добуток: " + sumAndProduct[1]);

        // 7. Квадрат кожного числа
        System.out.println("7. Квадрати чисел: " + calculateSquares(numbers));

        // 8. Сортування за довжиною
        List<String> wordsByLength = Arrays.asList("ДовгеСлово", "Кіт", "Собака", "Я");
        System.out.println("8. За довжиною: " + sortByLength(wordsByLength));

        // 9. Підрахунок слів у реченні
        String sentence = "Це речення має рівно шість окремих слів";
        System.out.println("9. Кількість слів: " + countWords(sentence));

        // 10. Перший непорожній рядок
        List<String> mixedStrings = Arrays.asList("", "  ", "Перший", "Другий");
        System.out.println("10. Перший непорожній: " + findFirstNonEmpty(mixedStrings));

        // 11. Перевірка великої літери
        List<String> capitalized = Arrays.asList("Київ", "Львів", "Одеса");
        System.out.println("11. Всі з великої літери? " + checkAllCapitalized(capitalized));

        // 12. Друге за величиною число
        List<Integer> randomNums = Arrays.asList(10, 5, 20, 20, 15);
        System.out.println("12. Друге за величиною: " + findSecondLargest(randomNums));

        // 13. Найбільше парне число
        System.out.println("13. Найбільше парне: " + findLargestEven(randomNums));
    }

    // --- МЕТОДИ ДЛЯ КОЖНОГО ЗАВДАННЯ ---

    // 1. Відфільтрувати непарні числа [cite: 28]
    public static List<Integer> filterOddNumbers(List<Integer> list) {
        return list.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
    }

    // 2. Знайти середнє зі списку дійсних значень [cite: 29]
    public static double findAverage(List<Double> list) {
        return list.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    // 3. Сортування списку рядків в алфавітному порядку [cite: 30]
    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 4. Обчислення суми всіх парних чисел [cite: 31]
    public static int sumOfEvens(List<Integer> list) {
        return list.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 5. Обчислити факторіал заданого числа [cite: 32]
    public static long calculateFactorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToLong(i -> i)
                .reduce(1, (a, b) -> a * b);
    }

    // 6. Розрахувати множення та підсумовування всіх елементів [cite: 33]
    public static long[] calculateSumAndProduct(List<Integer> list) {
        long sum = list.stream().mapToLong(Integer::longValue).sum();
        long product = list.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
        return new long[]{sum, product};
    }

    // 7. Квадрат кожного числа [cite: 34]
    public static List<Integer> calculateSquares(List<Integer> list) {
        return list.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    // 8. Сортування рядків на основі їх довжини в порядку зростання [cite: 34]
    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    // 9. Підрахувати кількість слів у реченні (розділені пробілами) [cite: 35]
    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return Arrays.stream(sentence.trim().split("\\s+"))
                .count();
    }

    // 10. Знайти перший непорожній рядок у списку [cite: 36]
    public static String findFirstNonEmpty(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .findFirst()
                .orElse("Не знайдено");
    }

    // 11. Перевірити, чи всі рядки починаються з великої літери [cite: 37]
    public static boolean checkAllCapitalized(List<String> list) {
        return list.stream()
                .allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    // 12. Знайти друге за величиною число [cite: 38]
    public static Integer findSecondLargest(List<Integer> list) {
        return list.stream()
                .distinct() // Видаляємо дублікати
                .sorted(Comparator.reverseOrder())
                .skip(1) // Пропускаємо перше найбільше
                .findFirst()
                .orElse(null);
    }

    // 13. Знайти найбільше парне число [cite: 38]
    public static Integer findLargestEven(List<Integer> list) {
        return list.stream()
                .filter(num -> num % 2 == 0)
                .max(Integer::compareTo)
                .orElse(null);
    }
}