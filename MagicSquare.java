import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MagicSquare {

    private static final int[] MAGIC_SQUARES = new int[]{
            8, 1, 6, 3, 5, 7, 4, 9, 2,
            6, 1, 8, 7, 5, 3, 2, 9, 4,
            4, 9, 2, 3, 5, 7, 8, 1, 6,
            2, 9, 4, 7, 5, 3, 6, 1, 8,
            8, 3, 4, 1, 5, 9, 6, 7, 2,
            4, 3, 8, 9, 5, 1, 2, 7, 6,
            6, 7, 2, 1, 5, 9, 8, 3, 4,
            2, 7, 6, 9, 5, 1, 4, 3, 8
    };


    static int[] cost = new int[9];

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int magicSolutions = MAGIC_SQUARES.length;
        for(int k = 0; k< 8; k++) {
            cost[k] = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost[k] += Math.abs(s[i][j] - MAGIC_SQUARES[8 * k + i*3 + j]);
                }
            }
        }
        int leastCost = Integer.MAX_VALUE;
        for(int c : cost) {

            leastCost = leastCost < c ? leastCost : c;
        }
        return leastCost;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
