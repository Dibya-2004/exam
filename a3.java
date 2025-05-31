
import java.util.Scanner;

	class Result {
	    boolean flag;
	    int start;
	    int end;

	    public Result(boolean flag, int start, int end) {
	        this.flag = flag;
	        this.start = start;
	        this.end = end;
	    }
	}
	public class a3 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the number of elements for first array:");
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        System.out.println("Enter the elements: ");
	        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
	        sc.close();

	        Result result = checkReverse(arr, n);
	        System.out.println("Can the array be sorted by reversing a subarray ? " + result.flag);
	        System.out.println("Starting index of subarray: " + result.start);
	        System.out.println("Ending index of subarray: " + result.end);
	    }

	    public static Result checkReverse(int[] arr, int n) {
	        int start = -1, end = -1;

	        for (int i = 0; i < n - 1; i++) {
	            if (arr[i] > arr[i + 1]) {
	                start = i;
	                break;
	            }
	        }

	        if (start == -1) return new Result(false, start, end);

	        for (int i = n - 1; i > 0; i--) {
	            if (arr[i] < arr[i - 1]) {
	                end = i;
	                break;
	            }
	        }

	        reverse(arr, start, end);
	        return new Result(true, start+1, end+1);
	    }

	    private static void reverse(int[] arr, int start, int end) {
	        while (start < end) {
	            int temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            start++;
	            end--;
	        }
	    }
	}