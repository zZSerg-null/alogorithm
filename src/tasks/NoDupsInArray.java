package tasks;

import java.util.Arrays;

public class NoDupsInArray {

    private void noDups(int[] array) {
        System.out.println(Arrays.toString(array));
        int position = 1;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] != array[i - 1]) {
                array[position] = array[i];
                position++;
            }
        }
        for (int i = position; i < array.length; i++) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

}
