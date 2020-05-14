//Jerin D Joy created on 31-Mar-20

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] word = w.toCharArray();
        int i = word.length - 1;
        while (i > 0 && word[i] <= word[i-1]) {
            --i;
        }
        if(i <= 0)
            return "no answer";
        //pivot is i - 1
        int j = word.length - 1;
        while (word[j] <= word[i-1]) {
            --j;
        }
        char temp = word[j];
        word[j] = word[i - 1];
        word[i - 1] = temp;
        int k = word.length - 1;
        while (i < k) {
            char c = word[i];
            word[i] = word[k];
            word[k] = c;
            ++i;
            --k;
        }
        return String.valueOf(word);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            /*bufferedWriter.write(result);
            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
