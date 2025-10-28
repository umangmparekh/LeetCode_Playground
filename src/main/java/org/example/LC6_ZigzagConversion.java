package org.example;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class LC6_ZigzagConversion {

    public static void main(String[] args) {
        String input1 = "PAYPALISHIRING";
        System.out.println("Input :-> "+" | No of rows>> "+3+" Convert String >> "+convert(input1, 3));
        String input2 = "PAYPALISHIRING";
        System.out.println("Input :-> "+input2+" | No of rows>> "+4+" Convert String >> "+convert(input2, 4));
        String input3 = "A";
        System.out.println("Input :-> "+input3+" | No of rows>> "+1+" Convert String >> "+convert(input3, 1));

    }
    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int row = 0; row < numRows; row++) {
            rows[row] = new StringBuilder();
        }

        int currentRow = 0;  // Current row index
        int direction = -1;  // Direction of movement: -1 for up, 1 for down

        for (char character : s.toCharArray()) {

            rows[currentRow].append(character);
            // Change direction when reaching the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction = -direction;
            }
            // Move to the next row based on current direction
            currentRow += direction;


        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
