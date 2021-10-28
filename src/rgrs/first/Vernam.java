package rgrs.first;

public class Vernam {
    private Vernam() {}

    public static int[] generateKey(int msgLength) {
        int[] key = new int[msgLength];

        // Случайный символ длиной 2 байта
        for (int i = 0; i < msgLength; i++)
            key[i] = (char) (Math.random() * (1 << 16));

        return key;
    }

    public static String stringifyKey(int[] key) {
        StringBuilder result = new StringBuilder();

        for (int n : key)
            result.append((char) n);

        return result.toString();
    }

    public static String process(String str, int[] key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < key.length; i++)
            result.append((char) (str.charAt(i) ^ key[i]));

        return result.toString();
    }
}
