package tasks;

import java.util.ArrayList;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s.length() < 3 || numRows == 1){
            return s;
        }

        ArrayList<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int row = 0;
        boolean forward = true;
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));

            if (forward) {
                row++;
            } else {
                row--;
            }
            if (row == 0){
                forward = true;
            } else if (row == numRows-1){
                forward = false;
            }
        }

        StringBuilder stringBuilder = rows.get(0);
        for (int i = 1; i < rows.size(); i++) {
            stringBuilder.append(rows.get(i));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println( convert("PAYPALISHIRING",  4) );
    }

}
//PINALSIGYAHRPI
//PINALSIGYAHRPI
