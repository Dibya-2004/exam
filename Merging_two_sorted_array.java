
import java.util.Scanner;
public class Merging_two_sorted_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of 1st array");
        int n1=sc.nextInt();
        System.out.println("enter the size of 2nd array");
        int n2=sc.nextInt();
        int arr1[]=new int[n1];
        int arr2[]=new int[n2];
        System.out.println("enter 1st array");
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter 2st array");
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        for(int i=0;i<n1;i++){
                if (arr1[i]>arr2[0]) {
                    int temp=arr1[i];
                    arr1[i]=arr2[0];
                    arr2[0]=temp;
                    Sort(arr2);                 
                }
        }
        System.out.println("1st array");
        for(int i=0;i<n1;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        System.out.println("2nd array");
        for(int i=0;i<n2;i++){
            System.out.print(arr2[i]+" ");
        }
    }
    public static int[] Sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }
   
    
}