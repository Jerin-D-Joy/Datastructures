import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Working solution
public class QueensAttack3 {

    static class Cell {
        int row;
        int col;
        int distance;

        public Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        String rowRight = "RR";
        String rowLeft = "RL";
        String columnUp = "CU";
        String columnDown = "CD";
        String diagonalRightUp = "DRU";
        String diagonalLeftDown = "DLD";
        String diagonalLeftUp = "DLU";
        String diagonalRightDown = "DRD";
        Map<String, Cell> obstacleMap = new HashMap<>();
        obstacleMap.put(rowRight, new Cell(0, 0, n - c_q));
        obstacleMap.put(rowLeft, new Cell(0, 0, c_q - 1));
        obstacleMap.put(columnUp, new Cell(0, 0, n - r_q));
        obstacleMap.put(columnDown, new Cell(0, 0, r_q - 1));
        obstacleMap.put(diagonalRightUp, new Cell(0, 0, Math.min(n - r_q, n - c_q)));
        obstacleMap.put(diagonalLeftDown, new Cell(0, 0, Math.min(r_q - 1, c_q - 1)));
        obstacleMap.put(diagonalLeftUp, new Cell(0, 0, Math.min(n - r_q, c_q - 1)));
        obstacleMap.put(diagonalRightDown, new Cell(0, 0, Math.min(r_q - 1, n - c_q)));

        for (int[] obstacle : obstacles) {
            int row = obstacle[0];
            int col = obstacle[1];
            int distanceFromRow = r_q - row; // +ve if obstacle is below, -ve if above
            int distanceFromCol = c_q - col;  //+ve if obstacle is left, -ve if right
            if (row == r_q) {
                if (distanceFromCol > 0 && distanceFromCol-1 < obstacleMap.get(rowLeft).distance)  //rowleft
                    obstacleMap.put(rowLeft, new Cell(row, col, distanceFromCol-1));
                else if (distanceFromCol < 0 && -distanceFromCol-1 < obstacleMap.get(rowRight).distance) //row right
                    obstacleMap.put(rowRight, new Cell(row, col, -distanceFromCol-1));
            } else if (col == c_q) {
                if (distanceFromRow < 0 && -distanceFromRow-1 < obstacleMap.get(columnUp).distance)
                    obstacleMap.put(columnUp, new Cell(row, col, -distanceFromRow-1));
                else if (distanceFromRow > 0 && distanceFromRow-1 < obstacleMap.get(columnDown).distance)
                    obstacleMap.put(columnDown, new Cell(row, col, distanceFromRow-1));
            } else if (distanceFromRow == distanceFromCol) {   //diagonal
                if (distanceFromRow < 0 && (-distanceFromRow)-1 < obstacleMap.get(diagonalRightUp).distance) { //rightUp
                    obstacleMap.put(diagonalRightUp, new Cell(row, col, -distanceFromRow-1));
                } else if (distanceFromRow > 0 && distanceFromRow-1 < obstacleMap.get(diagonalLeftDown).distance) {//left down
                    obstacleMap.put(diagonalLeftDown, new Cell(row, col, distanceFromRow-1));
                }
            } else if (distanceFromRow == -distanceFromCol) {   //diagonal
                if (distanceFromRow < 0 && distanceFromCol-1 < obstacleMap.get(diagonalLeftUp).distance) { //left up
                    obstacleMap.put(diagonalLeftUp, new Cell(row, col, distanceFromCol-1));
                } else if (distanceFromCol < 0 && distanceFromRow -1< obstacleMap.get(diagonalRightDown).distance) { //right down
                    obstacleMap.put(diagonalRightDown, new Cell(row, col, distanceFromRow-1));
                }
            }
        }
        int count = 0;
        for (Cell cell : obstacleMap.values()) {
            System.out.println(cell.row + "  " + cell.col + "  " + cell.distance);
            count += cell.distance;
        }
        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

     /*   bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/
        scanner.close();
    }
}
