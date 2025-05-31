import java.util.Scanner;
public class Queue {
        public static final int MAX = 5;
        public static int front = -1;
        public static int rear = -1;
        public static void insert(int Q[]){
            Scanner sc = new Scanner(System.in);
            if(is_Full()){
                System.out.println("is_Full");
            }
            else{
               if(front==-1){
                   front++;
                   rear++;
                   System.out.println("Enter Element: ");
                   Q[front]=sc.nextInt();
               }
               else{
                   rear++;
                   System.out.println("Enter Element: ");
                   Q[rear]=sc.nextInt();
               }
            }
        }
        public static boolean is_Full(){
            return rear == MAX - 1;
        }
        public static boolean is_empty(){
            return rear == -1;
        }
        public static void delete(int Q[]) {
            if (is_empty()) {
                System.out.println("Your list is empty");
            }
            else {
                int removed = Q[0];
                System.out.println("Removed item: " + removed);
                for (int i = 1; i <= rear; i++) {
                    Q[i - 1] = Q[i];
                }
                rear--;
            }
        }
        public static void display(int Q[]){
            if(is_empty()){
                System.out.println("Your Queue is empty");
            }
            else{
                for(int i = front ; i<=rear ; i++){
                    System.out.println("The Elements are "+Q[i]);
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int queue[] = new int[MAX];
            while (true) {
                System.out.println("0: Exit");
                System.out.print("1: Enqueue");
                System.out.println("2: Dequeque");
                System.out.println("3: Display");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        System.exit(0);
                    case 1:
                        insert(queue);
                        break;
                    case 2:
                        delete(queue);
                        break;
                    case 3:
                        display(queue);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }