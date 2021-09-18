package labs.second;

import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Лабораторная работа №2\n");

        System.out.println("Шифр Виженера\n----------");
        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();

        String cryptogram = Vigenere.encrypt(message, key);
        System.out.println("Шифр: " + cryptogram);
        String originalMessage = Vigenere.decrypt(cryptogram, key);
        System.out.println("Исходное сообщение: " + originalMessage);
    }
}
