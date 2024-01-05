package sort.other;

import sort.BasicSortClass;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetSort extends BasicSortClass {

    public long sort(int[] array) {
        Set<Integer> tree = new TreeSet<>();
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            tree.add(array[i]);
        }

        int x = 0;
        for (Integer i : tree) {
            array[x++] = i;
        }

        long endTime = System.nanoTime();

        System.out.println(showResult(startTime, endTime) + " - tree set sort");
        return endTime - startTime;
    }
}
