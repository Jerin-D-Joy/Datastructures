//2 way MergeSort combines 2 sorted arrays into single sorted array
//Merge Sort splits an array into subparts and combine them as sorted array

public class MergeSort {

    void merge(int[] arr, int l, int mid, int h) {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        int[] tempLeftArr = new int[n1];
        int[] tempRightArr = new int[n2];
        for(int i = 0; i < n1; i++) {
            tempLeftArr[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++) {
            tempRightArr[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if(tempLeftArr[i] < tempRightArr[j]) {
                arr[k++] = tempLeftArr[i++];
            } else {
                arr[k++] = tempRightArr[j++];
            }
        }
        while (i < n1) {
            arr[k++] = tempLeftArr[i++];
        }
        while (j < n2) {
            arr[k++] = tempRightArr[j++];
        }
    }

    void mergesort(int[] arr, int l, int h) {
        if(l < h) {
            int mid = l + (h - l)/ 2; //same as (l + h)/2 but avoids overflow error
            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 90, 80, 65, 30, 25, 15, 20};
        MergeSort ms = new MergeSort();
        ms.mergesort(arr, 0, arr.length - 1);
        for (int a: arr) {
            System.out.print(a + "   ");
        }
    }
}
