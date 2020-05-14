public class QuickSort {

    int[] arr = new int[20];
    int capacity = 0;

    void clearAndAdd(int[] newArray) {
        capacity = 0;
        for(int i = 0; i < newArray.length && i < 19; i++, capacity++) {
            arr[i] = newArray[i];
        }
        arr[capacity++] = Integer.MAX_VALUE;
    }

    int partition(int l, int h) { //takes o(n) time
        int pivot = arr[l];
        int i = l;
        int j = h;
        while (i < j) {
            do {
                ++i;
            } while (arr[i] <= pivot);
            do {
                --j;
            } while (arr[j] > pivot);
            if (i < j) {
                swap(i, j);
            }
        }
        swap(j, l);
        return j;
    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;;
    }

    void quicksort(int l, int h) {  //takes O(logn) time
        if(l < h) {
            int mid = partition(l, h);
            quicksort(l, mid); //not mid - 1 because mid will act as MAX element for 1st list
            quicksort(mid + 1, h);
        }
    }

    void printArray() {
        for(int i = 0; i < capacity - 1; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.clearAndAdd(new int[]{8, 5, 4, 10, 3, 1});
        quickSort.quicksort(0, 6);
        quickSort.printArray();
    }
}
