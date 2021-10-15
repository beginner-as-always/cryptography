package rgrs.first;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String title = "Расчетно-графическая работа №1";

        System.out.println(title);
        System.out.println("-".repeat(title.length()));

        System.out.print("Введите сообщение: ");

        String message = new Scanner(System.in).nextLine();
        int[] key = Vernam.generateKey(message.length());

        String cryptogram = Vernam.process(message, key);
        String decryptedMessage = Vernam.process(cryptogram, key);

        System.out.println("Шифр: " + cryptogram);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);
    }
}
