package rgrs.first;

public class Vernam {
    public static int[] generateKey(int msgLength) {
        int[] key = new int[msgLength];

        for (int i = 0; i < msgLength; i++)
            key[i] = (int) (Math.random() * Integer.MAX_VALUE);

        return key;
    }

    public static String process(String str, int[] key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < key.length; i++)
            result.append((char) ((int) str.charAt(i) ^ key[i]));

        return result.toString();
    }
}
