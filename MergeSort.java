public class MergeSort {
    public static void mergeSort(int[] arr, int L, int R) {
        if (L < R) {
            int mid = L + (R - L) / 2;
            mergeSort(arr, L, mid);
            mergeSort(arr, mid + 1, R);
            merge(arr, L, mid, R);
        }
    }
    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 8, 68, 99, 7, 6, 1, 3};

        System.out.print("Before Sorting: ");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("After Sorting: ");
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}

