import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack {

    static class Cell extends Object {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object object) {
            Cell cell = (Cell) object;
            return this.row == cell.row && this.col == cell.col;
        }


        @Override
        public int hashCode() {
            return this.row + this.col;
        }

    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        List<Cell> obstacleCells = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int row = obstacles[i][0];
            int col = obstacles[i][1];
            obstacleCells.add(new Cell(row, col));
        }
        Map<String, Cell> obstacleMap = new HashMap<>();
        Cell maxCell = new Cell(n, n);
        Cell minCell = new Cell(0, 0);
        for(Cell cell: obstacleCells) {
            if(cell.row == r_q && cell.col > c_q
                    && cell.col < obstacleMap.getOrDefault("RR", maxCell).col) {
                obstacleMap.put("RR", cell);
            }
            else if(cell.row == r_q && cell.col < c_q
                    && cell.col > obstacleMap.getOrDefault("RL", minCell).col) {
                obstacleMap.put("RL", cell);
            }
            else if(cell.col == c_q && cell.row > r_q
                    && cell.row < obstacleMap.getOrDefault("CU", maxCell).row) {
                obstacleMap.put("CU", cell);
            }
            else if(cell.col == c_q && cell.row < r_q
                    && cell.row > obstacleMap.getOrDefault("CD", minCell).row) {
                obstacleMap.put("CD", cell);
            } else {
                boolean flag = false;
                for (int i = r_q + 1, j = c_q + 1; !flag && i <= n && j <= n; i++, j++) {
                    if(cell.row == i && cell.col == j
                            && cell.row < obstacleMap.getOrDefault("DRU", maxCell).row) {
                        obstacleMap.put("DRU", cell);
                        flag = true;
                    }
                }
                for (int i = r_q - 1, j = c_q - 1; !flag && i > 0 && j > 0; i--, j--) {
                    if(cell.row == i && cell.col == j
                            && cell.row > obstacleMap.getOrDefault("DLD", minCell).row) {
                        obstacleMap.put("DLD", cell);
                        flag = true;
                    }
                }
                Cell maxDiagRightDownCell = new Cell(0, 9);
                for (int i = r_q - 1, j = c_q + 1; !flag && i > 0 && j <= n; i--, j++) {
                    if(cell.row == i && cell.col == j
                            && cell.row < obstacleMap.getOrDefault("DRD", maxDiagRightDownCell).row) {
                        obstacleMap.put("DRD", cell);
                        flag = true;
                    }
                }
                Cell maxDiagLeftUpCell = new Cell(9, 0);
                for (int i = r_q + 1, j = c_q - 1; !flag && i <= n && j > 0; i++, j--) {
                    if(cell.row == i && cell.col == j
                            && cell.row > obstacleMap.getOrDefault("DLU", maxDiagLeftUpCell).row) {
                        obstacleMap.put("DLU", cell);
                        flag = true;
                    }
                }
            }
        }

        Set<Cell> attackedCells = new HashSet<>();
        int end = obstacleMap.containsKey("RR") ? obstacleMap.get("RR").col - 1 : n;
        for (int i = c_q + 1; i <= end; i++) {
            attackedCells.add(new Cell(r_q, i));
        }
        end = obstacleMap.containsKey("RL") ? obstacleMap.get("RL").col + 1 : 1;
        for (int i = c_q - 1; i >= end; i--) {
            attackedCells.add(new Cell(r_q, i));
        }
        end = obstacleMap.containsKey("CU") ? obstacleMap.get("CU").row - 1 : n;
        for (int i = r_q + 1; i <= end; i++) {
            attackedCells.add(new Cell(i, c_q));
        }
        end = obstacleMap.containsKey("CD") ? obstacleMap.get("CD").row + 1 : 1;
        for (int i = r_q - 1; i >= end; i--) {
            attackedCells.add(new Cell(i, c_q));
        }
        int endRow = obstacleMap.containsKey("DRU") ? obstacleMap.get("DRU").row - 1 : n;
        int endCol = obstacleMap.containsKey("DRU") ? obstacleMap.get("DRU").col - 1: n;
        for (int i = r_q + 1, j = c_q + 1; i <= endRow && j <= endCol; i++, j++) {
            attackedCells.add(new Cell(i, j));
        }
        endRow = obstacleMap.containsKey("DLD") ? obstacleMap.get("DLD").row + 1: 1;
        endCol = obstacleMap.containsKey("DLD") ? obstacleMap.get("DLD").col + 1: 1;
        for (int i = r_q - 1, j = c_q - 1; i >= endRow && j >= endCol; i--, j--) {
            attackedCells.add(new Cell(i, j));
        }
        endRow = obstacleMap.containsKey("DRD") ? obstacleMap.get("DRD").row + 1: 1;
        endCol = obstacleMap.containsKey("DRD") ? obstacleMap.get("DRD").col - 1: n;
        for (int i = r_q - 1, j = c_q + 1; i >= endRow && j <= endCol; i--, j++) {
            attackedCells.add(new Cell(i, j));
        }
        endRow = obstacleMap.containsKey("DLU") ? obstacleMap.get("DLU").row - 1 : n;
        endCol = obstacleMap.containsKey("DLU") ? obstacleMap.get("DLU").col + 1 : 1;
        for (int i = r_q + 1, j = c_q - 1; i <= endRow && j >= endCol; i++, j--) {
            attackedCells.add(new Cell(i, j));
        }
        return attackedCells.size();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

/*

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/

        scanner.close();
    }
}
