//Jerin D Joy created on 31-Mar-20

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

        // Complete the encryption function below.
        static String encryption(String s) {

            String modified = s.replaceAll("\\s+", "");
            int length = modified.length();
            char[] array = modified.toCharArray();
            double root = Math.sqrt(length);
            int rows = (int) root;
            int cols = root - rows == 0 ? rows : rows + 1;
            if(rows*cols < length)
                ++rows;
            char[] encrypted = new char[cols*rows + cols];
            int k = 0;
            for(int i = 0; i < cols; i++) {
                for(int j = 0; j<rows; j++) {
                    if(i + j*cols < length) {
                        encrypted[k++] = array[i + j*cols];
                    }
                }
                encrypted[k++] = ' ';
            }

            for (char ch: encrypted) {
                System.out.print(ch);
            }
            return String.valueOf(encrypted).trim();
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            String result = encryption(s);
/*

            bufferedWriter.write(result);
            bufferedWriter.newLine();

            bufferedWriter.close();
*/

            scanner.close();
        }

}
