package labs.third;

import java.util.ArrayList;
import java.util.List;

public class SDES {
    private static final int[] P10_TABLE = {2, 4, 1, 6, 3, 9, 0, 8, 7, 5};
    private static final int[] P8_TABLE = {5, 2, 6, 3, 7, 4, 9, 8};

    private SDES() {}

    public static List<List<Integer>> generateKeys(List<Integer> p10) {
        if (p10.size() != 10)
            throw new IllegalArgumentException("Length of the key must be 10 bits");

        p10 = permuteP10(p10);

        List<Integer> leftHalf = p10.subList(0, 5);
        List<Integer> rightHalf = p10.subList(5, p10.size());

        List<Integer> firstKey = permuteP8(shift(leftHalf, -1), shift(rightHalf, -1));
        List<Integer> secondKey = permuteP8(shift(leftHalf, -3), shift(rightHalf, -3));

        return List.of(firstKey, secondKey);
    }

    private static List<Integer> permuteP10(List<Integer> p10) {
        List<Integer> result = new ArrayList<>();

        for (int i : P10_TABLE)
            result.add(p10.get(i));

        return result;
    }

    private static List<Integer> permuteP8(List<Integer> p51, List<Integer> p52) {
        List<Integer> result = new ArrayList<>();

        for (int i : P8_TABLE) {
            if (i < p51.size())
                result.add(p51.get(i));
            else
                result.add(p52.get(i % p52.size()));
        }

        return result;
    }

    private static List<Integer> shift(List<Integer> list, int shift) {
        List<Integer> result = new ArrayList<>();
        shift %= list.size();

        for (int i = 0; i < list.size(); i++)
            result.add(list.get((i - shift + list.size()) % list.size()));

        return result;
    }
}
