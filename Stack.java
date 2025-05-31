import java.util.Scanner;

public class Stake{
public int push(int[] arr,int top) {
    Scanner sc = new Scanner(System.in);
    if (top>arr.length-1) {
        System.out.println("Stack is full");
        return top;
    }
    System.out.println("Enter an item: ");
    int item = sc.nextInt();
    top++;
    arr[top] = item;
    return top;
}
public int pop(int arr[],int top){
    if (top<0) {
        System.out.println("Stack is empty");
        return top;
    }
    int remove= arr[top];
    System.out.println("Removed item: " + remove);
    top--;
    return top;
}
public void displayTop(int arr[],int top) {
    if (top<0){
        System.out.println(" stack is empty");
    } else {
            System.out.println(arr[top]);
        }
    
}
public void display(int arr[],int top) {
    if (top<0) {
        System.out.println( "stack is empty");
    } else {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of stack: ");
    int max = sc.nextInt();
    int [] arr = new int[max];
    int top = -1;
    Stake k = new Stake();
    while (true) {
        System.out.println("*MENU*");
        System.out.print("0: Exit");
        System.out.print(" 1: Push");
        System.out.print(" 2: Pop");
        System.out.print(" 3: Display");
        System.out.println(" 4: Display top");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.exit(0);
            case 1:
            top = k.push(arr,top);
                break;
            case 2:
            top = k.pop(arr,top);
                break;
            case 3:
                k.display(arr,top);
                break;
            case 4:
                k.displayTop(arr,top);
            default:
                System.out.println("Invalid choice");
        }
    }
}
}