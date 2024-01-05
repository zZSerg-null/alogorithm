package TEST;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studCount = scanner.nextInt();

        int arr1[] = new int[studCount];
        int arr2[] = new int[studCount];
        int realCount = 0;

        while (scanner.hasNextInt()){
            int x = scanner.nextInt();

            arr1[realCount] = x;

            if (realCount == 0){
                arr2[realCount++] = x;
            } else {
                arr2[realCount] = arr2[realCount-1] + x;
                realCount++;
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr2.length; i++) {
          if (i > 0) {
              int a = arr1[i] * i-1;
              int b = arr2[i-1];
              int c = Math.abs(b - a);
              System.out.println(c);
            }
        }
        System.out.println(Arrays.toString(arr2));
    }


}

//44 36 36 32 28 28 28 32 38 46