package labs.third;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String title = "Лабораторная работа №3";

        System.out.println(title);
        System.out.println("-".repeat(title.length()));

        System.out.println("Генерация ключей S-DES\n");

        List<Integer> key = List.of(1, 1, 1, 1, 1, 1, 0, 1, 0, 1);

        System.out.println("Исходный 10-битный ключ: " + key);

        List<List<Integer>> generatedKeys = SDES.generateKeys(key);
        System.out.println("Сгенерированные 8-битные ключи: \n" +
                "\t" + generatedKeys.get(0) + "\n" +
                "\t" + generatedKeys.get(1));
    }
}
