package labs.first;

import util.Utils;

import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Лабораторная работа №1\n");

        System.out.println("Шифр Цезаря\n----------");
        caesar();

        System.out.println("\n####################\n");

        System.out.println("Решетка Кардано\n----------");
        cardan();
    }

    private static void caesar() {
        System.out.print("Введите сообщение: ");
        String input = scanner.nextLine();
        System.out.print("Сдвиг: ");
        int shift = Integer.parseInt(scanner.nextLine());

        String cipher = Caesar.process(input, shift);
        System.out.println("Шифр: " + cipher);
    }

    private static void cardan() {
        System.out.print("Введите сообщение: ");
        String input = scanner.nextLine();
        System.out.println();

        Cardan cardan = new Cardan(input);

        char[][] cryptogram = cardan.encrypt();
        int[][] cardanGrille = cardan.getGrille();
        String originalMessage = cardan.decrypt(cryptogram, cardanGrille);

        System.out.println("Шифр: ");
        Utils.printMatrix(cryptogram);

        System.out.println();
        System.out.println("Решетка Кардано: ");
        Utils.printMatrix(cardanGrille);

        System.out.println();
        System.out.println("Расшифрованное сообщение: ");
        System.out.println(originalMessage);
    }
}
