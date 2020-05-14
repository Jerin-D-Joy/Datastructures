//Jerin D Joy created on 30-Mar-20

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendAndDelete {


    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        char[] sArr = s != null ? s.toCharArray() : new char[0];
        char[] tArr = t != null ?t.toCharArray() : new char[0];
        int sLength = sArr.length;
        int tLength = tArr.length;
        int i = 0;
        while(i < sLength && i < tLength) {
            if(sArr[i] != tArr[i]) {
                break;
            }
            i++;
        }

        System.out.print(i);
        int diff = sLength + tLength - 2*i;  //sLength - i + tLength - i;
        //if k < diff, then no
        // if k>=diff, then either k should be greater than length of 2 strings or k and the difference should be
        // either odd or even. If abc and ab, then k should be 1, 3,... and not 2,4, etc.... This condition stops
        // when length of str s +  t becomes less than k
        if(k>=diff && (diff%2 == 0 && k%2 == 0 || diff%2 == 1 && k%2 == 1 || (sLength + tLength) < k)) {
            //abc abc 1     y yu 2 abc abcd 1 3 5
            return "Yes";
        } else {
            return "No";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

/*
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();
*/

        scanner.close();
    }
}
