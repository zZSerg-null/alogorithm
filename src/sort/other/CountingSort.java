package sort.other;

import sort.BasicSortClass;

import java.util.HashMap;
import java.util.Map;

public class CountingSort extends BasicSortClass {

    public long sort(int[] array) {
        long startTime = System.nanoTime();
        Map<Integer, Integer> temp = new HashMap<>();

        int[] newArr = new int[array.length];

        for (Integer value : array) {
            temp.put(value, temp.getOrDefault(value, 0) + 1);
        }

        int index = 0;
        for (var mapEntry : temp.entrySet()) {
            for (int i = 0; i < mapEntry.getValue(); i++) {
                newArr[index++] = mapEntry.getKey();
            }
        }

        long endTime = System.nanoTime();
        System.out.println(showResult(startTime, endTime) + " - counting sort");
        return endTime - startTime;
    }

}
