package Heaps;

public class MaxHeap {

    static void heapify(int[] arr, int l, int i) {
        int left = 2*i + 1, right = 2*i + 2;
        int largest = i;
        if (left < l && arr[largest] < arr[left])
            largest = left;
        if (right < l && arr[largest] < arr[right])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, l, largest);
        }
    }

    static void heapSort(int[] arr) {
        for (int i = 0; i <= arr.length/2; i++)
            heapify(arr, arr.length, i);

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i,0);
        }
    }

    static void print(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6,7};
        print(arr);
        heapSort(arr);
        print(arr);
    }
}
