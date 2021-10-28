package labs.first;

import util.Utils;
import java.util.Map;

public class Caesar {
    private static final char[] alphabet = Utils.getAlphabet();
    private static final Map<Character, Integer> alphabetMap = Utils.getAlphabetMap();

    private Caesar() {}

    public static String process(String message, int shift) {
        shift %= alphabet.length;
        message = Utils.removeNonWordCharacters(message);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            int pos = alphabetMap.get(message.charAt(i));
            result.append(alphabet[(pos + shift + alphabet.length) % alphabet.length]);
        }

        return result.toString();
    }
}
