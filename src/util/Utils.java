package util;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    private static final char[] alphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    private static final Map<Character, Integer> alphabetMap;

    static {
        alphabetMap = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++) {
            alphabetMap.put(alphabet[i], i);
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.printf("%-2s", c);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int n : row) {
                System.out.printf("%-2d", n);
            }
            System.out.println();
        }
    }

    public static String removeNonWordCharacters(String s) {
        return s.replaceAll("[\\p{Punct}\\s]", "").toUpperCase();
    }

    public static char[] getAlphabet() {
        return alphabet;
    }

    public static Map<Character, Integer> getAlphabetMap() {
        return alphabetMap;
    }
}
