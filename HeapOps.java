public class HeapOps {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    class BinaryTree {
        Node root;

        void addNode(int data) {
            Node newNode = new Node(data, null, null);
            Node curNode = root;
            if (curNode == null) {
                curNode = newNode;
                return;
            }
            while (curNode.left != null && curNode.right != null) {
                curNode = curNode.left;
            }
            if (curNode.left == null) {
                curNode.left = newNode;
                return;
            }
            if (curNode.right == null) {
                curNode.right = newNode;
                return;
            }
        }
    }

    //items are maximum at top and less towards the bottom
    static class MaxHeap {

        int[] data = new int[20];
        int position = 0;

        //the new element is added to the end of the queue and is floated up on comparison with its parent
        void add(int value) {
            if (position == 0) {
                data[++position] = value;
                return;
            }
            data[++position] = value;
            int currentPosition = position;
            int parent = currentPosition / 2;
            while (data[parent] < data[currentPosition] && parent > 0) {
                swap(currentPosition, parent);
                currentPosition = parent;
                parent = currentPosition / 2;
            }
        }

        //the max item is always removed and the last element takes its position. the last element is floated down
        int remove() {
            if (position == 0) {
                return -1;
            }
            int popped = data[1];
            data[1] = data[position--];
            int currentPosition = 1;
            int left;
            int right;
            int largest;
            int value;
            boolean flag = true;
            while (flag) {
                largest = currentPosition;
                left = currentPosition * 2;
                right = currentPosition * 2 + 1;
                if (left <= position && data[largest] < data[left]) {
                    largest = left;
                }
                if (right <= position && data[largest] < data[right]) {
                    largest = right;
                }
                if(largest != currentPosition) {
                    value = data[currentPosition];
                    data[currentPosition] = data[largest];
                    data[largest] = value;
                    currentPosition = largest;
                } else {
                    flag = false;
                }
            }
            return popped;
        }

        void swap(int position, int parent) {
            int temp = data[position];
            data[position] = data[parent];
            data[parent] = temp;
        }

        void printValues() {
            for(int i = 1; i <= position; i++) {
                System.out.print(data[i] + "  ");
            }
            System.out.println();
        }

        //heapify - take an array and create heap from last element to upwards
        //the leaf nodes are already heaps in itself. So we need to heapify from the last parent node
        void buildMaxHeap(int[] elements) {
            //since index of elements starts from 0 unlike the heap which index start at 1, parent = (n-1)/2
            //i.e ((elements.length - 1) - 1)/2
            int lastParent = elements.length/2 - 1;
            for(int i = lastParent; i>= 0; i--) {
                maxHeapify(elements, i, elements.length);
            }
            for (int element: elements) {
                System.out.print(element + "  ");
            }
        }

        void maxHeapify(int[] elements, int i, int n) {
            int left = 2*i + 1;
            int right = 2* i + 2;
            int largest = i;
            if(left < n && elements[largest] < elements[left]) {
                largest = left;
            }
            if(right < n && elements[largest] < elements[right]) {
                largest = right;
            }
            if(i != largest) {
                int temp = elements[i];
                elements[i] = elements[largest];
                elements[largest] = temp;
                maxHeapify(elements, largest, n);
            }
        }
    }

    static class MinHeap {

        int[] data = new int[20];
        int position = 0;

        void add(int element) {
            if(position == 0) {
                data[++position] = element;
                return;
            }
            data[++position] = element;
            int parent = position/2;
            int currentPosition = position;
            while (parent > 0 && data[currentPosition] < data[parent]) {
                int temp = data[currentPosition];
                data[currentPosition] = data[parent];
                data[parent] = temp;
                currentPosition = parent;
                parent = currentPosition/2;
            }
        }

        int remove() {
            int element = data[1];
            data[1] = data[position--];
            int smallest;
            int currentPosition = 1;
            int left, right;
            boolean flag = true;
            while (flag) {
                smallest = currentPosition;
                left = smallest * 2;
                right = smallest * 2 + 1;
                if(left <= position && data[left] < data[smallest]) {
                    smallest = left;
                }
                if(right <= position && data[right] < data[smallest]) {
                    smallest = right;
                }
                if(smallest != currentPosition) {
                    int temp = data[smallest];
                    data[smallest] = data[currentPosition];
                    data[currentPosition] = temp;
                } else {
                    flag = false;
                }
            }
            return element;
        }

        void printValues() {
            for(int i = 1; i <= position; i++) {
                System.out.print(data[i] + "  ");
            }
            System.out.println();
        }

        void buildMinHeap(int[] elements) {
            int n = elements.length;
            int lastParent = (n - 1)/2;
            for(int i = lastParent; i>= 0; i--) {
                minHeapify(elements, n, i);
            }
            for(int element : elements) {
                System.out.print(element + "  ");
            }
        }

        void minHeapify(int[] elements, int n, int i) {
            int smallest = i;
            int left = i*2 + 1;
            int right = i*2 + 2;
            if(left < n && elements[smallest] > elements[left]) {
                smallest = left;
            }
            if(right < n && elements[smallest] > elements[right]) {
                smallest = right;
            }
            if(smallest != i) {
                int temp = elements[smallest];
                elements[smallest] = elements[i];
                elements[i] = temp;
                minHeapify(elements, n, smallest);
            }
        }
    }

    public static void main(String[] args) {
        /*
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(10);
        maxHeap.add(15);
        maxHeap.printValues();
        maxHeap.add(20);
        maxHeap.add(25);
        maxHeap.add(30);
        maxHeap.printValues();
        maxHeap.add(35);
        maxHeap.add(40);
        maxHeap.add(50);
        maxHeap.printValues();
        maxHeap.remove();
        maxHeap.printValues();
        int nextMax = maxHeap.remove();
        System.out.println(nextMax);*/
        /*System.out.println("Demonstrating Heap Sort");
        int[] unsorted = {10, 20, 15, 30, 40};
        MaxHeap sortHeap = new MaxHeap();
        for (int element: unsorted) {
            sortHeap.add(element);
        }
        int[] sorted = new int[unsorted.length];
        for (int i = unsorted.length - 1; i >= 0 ; i--) {
            //sortHeap.printValues();
            sorted[i] = sortHeap.remove();
        }
        System.out.println("Sorted Array");
        for (int element : sorted) {
            System.out.print(element + "  ");
        }*/
        /*System.out.println("Demonstrating Heapify : ");
        int[] unsorted = {10, 20, 15, 30, 40};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.buildMaxHeap(unsorted);*/
        /*MinHeap minHeap = new MinHeap();
        minHeap.add(25);
        minHeap.add(32);
        minHeap.add(50);
        minHeap.add(40);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(10);
        minHeap.printValues();
        minHeap.remove();
        minHeap.printValues();*/
        /*System.out.println("Demonstrating Heap Sort");
        int[] unsorted = {10, 20, 15, 30, 40};
        MinHeap sortHeap = new MinHeap();
        for (int element: unsorted) {
            sortHeap.add(element);
        }
        int[] sorted = new int[unsorted.length];
        for (int i = 0; i < unsorted.length ; i++) {
            //sortHeap.printValues();
            sorted[i] = sortHeap.remove();
        }
        System.out.println("Sorted Array");
        for (int element : sorted) {
            System.out.print(element + "  ");
        }*/

        System.out.println("Demonstrating Heapify : ");
        int[] unsorted = {32, 25, 40, 50, 30, 20, 10};
        MinHeap minHeap = new MinHeap();
        minHeap.buildMinHeap(unsorted);
    }
}

