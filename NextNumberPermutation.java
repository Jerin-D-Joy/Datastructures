//Jerin D Joy created on 31-Mar-20

public class NextNumberPermutation {

    char[] nextPermutation(char[] number) {
        //eg : 125330
        int i = number.length - 1;
        // find longest increasing suffix | 5330
        while(i > 0 && number[i] <= number[i-1]) { //current digit less than prev digit
            --i;
        }
        //now i is at start index of suffix 5. so i -1 is pivot
        if(i<=0) { //already the biggest permutation
            return number;
        }
        //find 1st number from right greater than pivot
        int j = number.length - 1;
        System.out.println("Pivot : " + number[i - 1]);
        while (number[j] <= number[i - 1]) { //comparing with pivot. find immediate greatest num than pivot
            --j;
        }
        //swap pivot and j
        char temp = number[i-1];
        number[i - 1] = number[j];
        number[j] = temp;
        System.out.println(String.valueOf(number));
        //reverse the suffix starting from i
        int k = number.length - 1;
        while(i < k) {
            temp = number[k];
            number[k] = number[i];
            number[i] = temp;
            ++i;
            --k;
        }
        return number;
    }

    public static void main(String[] args) {
        char[] number = {'0', '1', '5', '3', '3', '0'};
        NextNumberPermutation permutation = new NextNumberPermutation();
        permutation.nextPermutation(number);
        for(char n : number)
        System.out.print(n);
    }
}
