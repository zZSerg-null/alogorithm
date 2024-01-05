package sort.merge;

import sort.SORT_TEST;

public class MergeSortMain {
    public static void main(String[] args) {
        SORT_TEST allTypeSorterClass = new SORT_TEST();
        int[] array = allTypeSorterClass.genArray(1_000_000, true);
        int[] array2 = array.clone();

        MergeTopDown mergeTopDown = new MergeTopDown();
        long sortResult1 = mergeTopDown.sort(array);

        MergeBottomUp mergeBottomUp = new MergeBottomUp();
        long sortResult2 = mergeBottomUp.sort(array2);

        System.out.print("С разницей в " + Math.abs(sortResult1 - sortResult2) + " наносекунд быстрее оказалась сортировка ");
        if (sortResult1 < sortResult2) {
            System.out.println("Top - Down");
        } else
            System.out.println("Bottom - Up");
    }

}
