import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack2 {


    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[][] chess = new int[n+1][n+1];
        for(int[] obstacle: obstacles) {
            int row = obstacle[0];
            int col = obstacle[1];
            chess[row][col] = -1;
        }
        for(int i = c_q + 1; i<=n; i++) {  //row right
            if(chess[r_q][i] == -1)
                break;
            chess[r_q][i] = 1;
        }

        for(int i = c_q - 1; i >= 1; i--) {  //row left
            if(chess[r_q][i] == -1)
                break;
            chess[r_q][i] = 1;
        }

        for(int i = r_q + 1; i<=n; i++) { //column up
            if(chess[i][c_q] == -1)
                break;
            chess[i][c_q] = 1;
        }

        for(int i = r_q - 1; i >= 1; i--) { //column down
            if(chess[i][c_q] == -1)
                break;
            chess[i][c_q] = 1;
        }

        for(int i = r_q + 1, j = c_q + 1; i<=n && j<=n; i++, j++) {   //diagonal right up
            if(chess[i][j] == -1)
                break;
            chess[i][j] = 1;
        }

        for(int i = r_q - 1, j = c_q - 1; i >= 1 && j >= 1; i--, j--) {   //diagonal left down
            if(chess[i][j] == -1)
                break;
            chess[i][j] = 1;
        }
        for(int i = r_q + 1, j = c_q - 1; i <= n && j >= 1; i++, j--) {   //diagonal left up
            if(chess[i][j] == -1)
                break;
            chess[i][j] = 1;
        }
        for(int i = r_q - 1, j = c_q + 1; i >= 1 && j <= n; i--, j++) {   //diagonal right down
            if(chess[i][j] == -1)
                break;
            chess[i][j] = 1;
        }
        int count = 0;
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(chess[i][j] == 1)
                    ++count;
            }
        }
        return count;
    }

    static void drawVisions(int[][] chess, int row, int col, int vision) {

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);


        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
