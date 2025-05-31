public class missingNo {
    public static void main(String[] args) {
        int[] array = { 1, 2, 6, 4, 5 };
        int n = array.length + 1;
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int missingNumber = findMissingNumber(array, n);
        System.out.println("Missing number: " + missingNumber);
    }

    public static int findMissingNumber(int[] array, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : array) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}