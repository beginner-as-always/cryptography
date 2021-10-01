package labs.first;

import util.Utils;
import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Лабораторная работа №1\n");
        System.out.println("1. Шифр Цезаря");
        System.out.println("2. Шифр Кардано\n");

        System.out.print("Ваш выбор: ");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                caesar();
                break;
            case 2:
                cardan();
                break;
            default:
                System.out.println("Выберите 1 или 2");
        }
    }

    private static void caesar() {
        System.out.println("\nШифр Цезаря\n----------");
        System.out.print("Введите сообщение: ");
        String input = scanner.nextLine();
        System.out.print("Сдвиг: ");
        int shift = Integer.parseInt(scanner.nextLine());

        String cipher = Caesar.process(input, shift);
        System.out.println("Шифр: " + cipher);
    }

    private static void cardan() {
        System.out.println("\nШифр Кардано\n----------");
        System.out.print("Введите сообщение: ");
        String input = scanner.nextLine();
        System.out.println();

        Cardan cardan = new Cardan(input);

        char[][] cryptogram = cardan.encrypt();
        int[][] cardanGrille = cardan.getGrille();
        String key = cardan.getKey();
        String originalMessage = cardan.decrypt(cryptogram, key);

        System.out.println("Шифр: ");
        Utils.printMatrix(cryptogram);

        System.out.println();
        System.out.println("Решетка Кардано: ");
        Utils.printMatrix(cardanGrille);

        System.out.println("\nКлюч: " + key);

        System.out.println();
        System.out.println("Расшифрованное сообщение: ");
        System.out.println(originalMessage);
    }
}
