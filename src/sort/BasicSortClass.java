package sort;

public class BasicSortClass {

    protected void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    protected String showResult(long start, long end) {
        long finalTime = end - start;
        double sec = (double) finalTime / 1_000_000_000.0;
        return String.format("%.7f", sec) + " секунд"; // Use %.7f for 7 decimal places
    }
}
