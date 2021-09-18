package labs.second;

import util.Utils;

import java.util.Map;

public class Vigenere {
    private static final char[] alphabet = Utils.getAlphabet();
    private static final Map<Character, Integer> alphabetMap = Utils.getAlphabetMap();

    public static String encrypt(String message, String key) {
        message = Utils.removeNonWordCharacters(message);
        key = adjustKeyLength(Utils.removeNonWordCharacters(key), message.length());

        StringBuilder cryptogram = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            int mi = alphabetMap.get(message.charAt(i));
            int ki = alphabetMap.get(key.charAt(i));

            cryptogram.append(alphabet[(mi + ki) % alphabet.length]);
        }

        return cryptogram.toString();
    }

    public static String decrypt(String cryptogram, String key) {
        cryptogram = Utils.removeNonWordCharacters(cryptogram);
        key = adjustKeyLength(Utils.removeNonWordCharacters(key), cryptogram.length());

        StringBuilder originalMessage = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            int ci = alphabetMap.get(cryptogram.charAt(i));
            int ki = alphabetMap.get(key.charAt(i));

            originalMessage.append(alphabet[(ci + alphabet.length - ki) % alphabet.length]);
        }

        return originalMessage.toString();
    }

    private static String adjustKeyLength(String key, int length) {
        StringBuilder result = new StringBuilder();

        result.append(key.repeat(length / key.length()));

        for (int i = 0; i < length % key.length(); i++) {
            result.append(key.charAt(i));
        }

        return result.toString();
    }
}
