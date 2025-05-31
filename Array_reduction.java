import java.util.Scanner;

public class Array_reduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of Array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the array: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int A = 0;
		for (int i = 0; i < n; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					break;
				}

			}
			if (i == j) {
				A++;
			}
		}
		System.out.println(A);
	}
}
