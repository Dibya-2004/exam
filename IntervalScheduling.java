import java.util.Arrays;
public class IntervalScheduling {
    public static void quicksort(char[] names, int[][] i, int s, int f) {
        if (s < f) {
            int p = partition(names, i, s, f);
            quicksort(names, i, s, p - 1);
            quicksort(names, i, p + 1, f);
        }
    }
    public static int partition(char[] names, int[][] i, int s, int f) {
        int pivot = i[f][1];
        int a = s - 1;
        for (int j = s; j < f; j++) {
            if (i[j][1] < pivot) {
                a++;
                int[] tempI = i[a];
                char tempN = names[a];
                i[a] = i[j];
                names[a] = names[j];
                i[j] = tempI;
                names[j] = tempN;
            }
        }
        int[] tempI = i[a + 1];
        char tempN = names[a + 1];
        i[a + 1] = i[f];
        names[a + 1] = names[f];
        i[f] = tempI;
        names[f] = tempN;
        return a + 1;
    }
    public static void intervalScheduling(char[] names, int[][] i) {
        int n = i.length;
        quicksort(names, i, 0, n - 1);
        int e = -1;
        System.out.print("Selected intervals: ");
        for (int j = 0; j < n; j++) {
            if (i[j][0] >= e) {
                System.out.print(names[j] + " ");
                e = i[j][1];
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char[] names = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        int[][] intervals = { { 0, 2 }, { 3, 4 }, { 3, 7 }, { 0, 1 }, { 2, 4 }, { 0, 1 }, { 4, 7 }, { 7, 9 }, { 6, 10 }, { 8, 10 } };
        intervalScheduling(names, intervals);
    }
}