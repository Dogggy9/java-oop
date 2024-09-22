package academy.devonline.java.section001_classes;

import academy.devonline.java.structures.DynaArray;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 4, -5, 2, 3, 4, 5, 6, 7, 8, 9};

        DynaArray result = getPositiveNumbers(array);

        System.out.println(result.toString());
    }

    private static DynaArray getPositiveNumbers(int[] array) {

        DynaArray dynaArray = new DynaArray();
        for (int value : array) {
            if (value > 0) {
                dynaArray.add(value);
            }
        }
        return dynaArray;
    }
}
