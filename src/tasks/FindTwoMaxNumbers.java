package tasks;

import java.util.Arrays;

public class FindTwoMaxNumbers {

    public static void main(String[] args) {
        String sequence = "-8 -33 -1 -9 -37 -22 22 6 2 4 1 6 7 50";
        int[] numbers = convertStringToArray(sequence);

        int[] maxProductNumbers = findMaxProductNumbers(numbers);

        System.out.println("Два числа с максимальным произведением: " + maxProductNumbers[0] + " и " + maxProductNumbers[1]);
    }

    // Приводим строку к массиву чисел
    private static int[] convertStringToArray(String sequence) {
        String[] numbersString = sequence.split(" ");
        int[] numbers = new int[numbersString.length];

        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        return numbers;
    }

    // Находим два числа с максимальным произведением
    private static int[] findMaxProductNumbers(int[] numbers) {
        Arrays.sort(numbers); // Сортируем массив по возрастанию

        int length = numbers.length;

        // Проверяем два случая:
        //              1) минимальные (возможно отрицательные числа) при умножении больше двух максимальных
        //              2) наброт
        // Для первого случая нужно выбрать два самых маленьких числа
        // Для второго случая нужно выбрать два самых больших числа
        if (numbers[0] * numbers[1] > numbers[length - 1] * numbers[length - 2]) {
            return new int[]{ numbers[0], numbers[1] };
        } else
            return new int[]{ numbers[length - 1], numbers[length - 2] };
    }
}
