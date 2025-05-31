public class repeatedNo {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 2, 3, 5, 6, 4 };
        printDuplicates(array);
    }

    public static void printDuplicates(int[] array) {
        System.out.print("elements: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Duplicate elements: ");
        boolean hasDuplicates = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.print(array[i] + " ");
                    hasDuplicates = true;
                    break;
                }
            }
        }

        if (!hasDuplicates) {
            System.out.print("No duplicates found.");
        }
    }
}