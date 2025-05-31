
    import java.util.Arrays;

    public class MinMaxDifference {
    public static void main(String[] args) {
        int[] arr = {3, 8, 15, 2, 17, 11};
        findMinMaxDifference(arr);
    }

    public static void findMinMaxDifference(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array should have at least two elements.");
            return;
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Minimum difference
        int minDiff = Integer.MAX_VALUE;
        int minPair1 = 0, minPair2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                minPair1 = arr[i - 1];
                minPair2 = arr[i];
            }
        }
        
        // Maximum difference
        int maxDiff = arr[arr.length - 1] - arr[0];
        int maxPair1 = arr[0];
        int maxPair2 = arr[arr.length - 1];
        
        // Output the results
        System.out.println("Minimum difference pair: (" + minPair1 + ", " + minPair2 + "), Difference = " + minDiff);
        System.out.println("Maximum difference pair: (" + maxPair1 + ", " + maxPair2 + "), Difference = " + maxDiff);
    }
}

