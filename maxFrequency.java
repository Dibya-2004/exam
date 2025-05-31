import java.util.Arrays;
public class maxFrequency{
        public static void main(String[] args) {
            int[] array = {1, 3, 2, 1, 3, 4, 1, 3, 2, 1,  3, 3};
            
            int maxElement = findMaxFrequencyElement(array);
            System.out.println("Element with maximum times: " + maxElement);
        }
    
        public static int findMaxFrequencyElement(int[] array) {
            Arrays.sort(array);
            int maxCount = 1;
            int currentCount = 1;
            int maxElement = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] == array[i - 1]) {
                    currentCount++;
                } else {
                        if (currentCount > maxCount) {
                        maxCount = currentCount;
                        maxElement = array[i - 1];
                    }
                    currentCount = 1;
                }
            }
            
            if (currentCount > maxCount) {
                maxElement = array[array.length - 1];
            }
            
            return maxElement;
        }
    }