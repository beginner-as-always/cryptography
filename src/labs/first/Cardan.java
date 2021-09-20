package labs.first;

import util.Utils;

import java.util.HashSet;
import java.util.Set;

public class Cardan {
    private static final int SMALL = 8;
    private static final int MEDIUM = 12;
    private static final int LARGE = 16;

    private char[] alphabet = Utils.getAlphabet();

    private int[][] constructor;
    private int[][] grille;
    private int size;

    private String message;
    private char[][] cryptogram;

    public Cardan(String message) {
        this.message = Utils.removeNonWordCharacters(message);

         if (this.message.length() <= 64)
             generateConstructor(SMALL);
         else if (this.message.length() <= 144)
             generateConstructor(MEDIUM);
         else if (this.message.length() <= 256)
             generateConstructor(LARGE);
         else
             throw new IllegalArgumentException("The message is too big!");

         size = constructor.length;
         generateGrille();
    }

    private void generateConstructor(int size) {
        constructor = new int[size][size];

        for (int i = 0, k = 1; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                constructor[i][j] = k++;
            }
        }

        for (int j = size - 1, k = 1; j >= size / 2; j--) {
            for (int i = 0; i < size / 2; i++) {
                constructor[i][j] = k++;
            }
        }

        for (int i = size - 1, k = 1; i >= size / 2; i--) {
            for (int j = size - 1; j >= size / 2; j--) {
                constructor[i][j] = k++;
            }
        }

        for (int j = 0, k = 1; j < size / 2; j++) {
            for (int i = size - 1; i >= size / 2; i--) {
                constructor[i][j] = k++;
            }
        }
    }

    private void generateGrille() {
        Set<Integer> set = new HashSet<>();
        grille = new int[size][size];

        while (set.size() < size * size / 4 && set.size() * 4 < message.length()) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);

            if (
//                Adjacency check
//                ((y > 0 && grille[x][y - 1] != 1) &&
//                (y < size - 1 && grille[x][y + 1] != 1) &&
//                (x > 0 && grille[x - 1][y] != 1) &&
//                (x < size - 1 && grille[x + 1][y] != 1)) &&
                set.add(constructor[x][y])
            )
                grille[x][y] = 1;
        }
    }

    public char[][] encrypt() {
        cryptogram = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cryptogram[i][j] = alphabet[(int)(Math.random() * alphabet.length)];
            }
        }

        int k = 0;

        for (int n = 0; n < 4; n++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grille[i][j] == 1 && k < message.length())
                        cryptogram[i][j] = message.charAt(k++);
                }
            }

            grille = rotateGrille(grille);
        }

        return cryptogram;
    }

    public String decrypt(char[][] cryptogram, int[][] grille) {
        StringBuilder result = new StringBuilder();

        int size = cryptogram.length;

        for (int n = 0; n < 4; n++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grille[i][j] == 1) {
                        result.append(cryptogram[i][j]);
                    }
                }
            }

            grille = rotateGrille(grille);
        }

        return result.toString();
    }

    private int[][] rotateGrille(int[][] grille) {
        int size = grille.length;
        int[][] result = new int[size][size];

        for (int i = 0, y = size - 1; i < size && y >= 0; i++, y--) {
            for (int j = 0, x = 0; j < size && x < size; j++, x++) {
                result[i][j] = grille[x][y];
            }
        }

        return result;
    }

    public int[][] getGrille() {
        return grille;
    }
}
