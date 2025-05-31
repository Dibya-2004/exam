
import java.util.Scanner;

class Node {
	int info;
	Node next;
}

public class LinkedList {
	static Node start = null;

	public static void create() {
		Scanner sc = new Scanner(System.in);
		Node p;
		Node q = null;
		int ch;
		do {
			p = new Node();
			System.out.println("Enter information: ");
			p.info = sc.nextInt();
			p.next = null;
			if (start == null) {
				start = p;
				q = p;
			} else {
				q.next = p;
				q = p;
			}
			System.out.println("Do you want to create more number of nodes(y/n)");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');
	}

	public static void InsBeg() {
		Scanner sc = new Scanner(System.in);
		Node p = new Node();
		System.out.println("Enter information: ");
		p.info = sc.nextInt();
		p.next = start;
		start = p;
	}

	public static void InsEnd() {
		Scanner sc = new Scanner(System.in);
		Node p = new Node();
		System.out.println("Enter information: ");
		p.info = sc.nextInt();
		p.next = null;
		if (start == null) {
			start = p;
		} else {
			Node q = start;
			while (q.next != null) {
				q = q.next;
			}
			q.next = p;
		}
	}

	public static void InsAny() {
		Scanner sc = new Scanner(System.in);
		Node p = new Node();
		System.out.println("Enter information: ");
		p.info = sc.nextInt();
		System.out.println("Enter position of new node: ");
		int pos = sc.nextInt();
		if (pos == 0) {
			System.out.println("Position does not exit in linkedlist: ");
		} else if (start == null || pos == 1) {
			p.next = start;
			start = p;
			System.out.println("Node add first position: ");
		} else {
			Node q = start;
			for (int i = 1; i < pos - 1 && q.next != null; i++) {
				q = q.next;
			}
			if (q.next == null) {
				q.next = p;
				p.next = null;
				System.out.println("position not found, so new Node add last position: ");
			} else {
				p.next = q.next;
				q.next = p;
				System.out.println("New node add " + pos + " position");
			}
		}
	}

	public static void DelBeg() {
		if (start == null) {
			System.out.println("Empty linkedlist");
		} else {
			Node p = start;
			start = start.next;
			System.out.println("Delete node information");
			System.out.println(p.info + "---------");
		}
	}

	public static void DelEnd() {
		if (start == null) {
			System.out.println("Empty linkedlist");
		} else {
			Node p = start;
			Node q = start;
			while (p.next != null) {
				q = p;
				p = p.next;
			}
			q.next = null;
			System.out.println("Delete node information");
			System.out.println(p.info + "---------");
		}
	}

	public static void DelAny() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter position of deleted node: ");
		int pos = sc.nextInt();
		if (start == null) {
			System.out.println("Empty linkedlist, delete not posible");
		} else if (pos == 1) {
			Node q = start;
			start = start.next;
			System.out.println("Delete node information");
		} else {
			Node q = start;
			Node p = start;
			for (int i = 1; i < pos && p.next != null; i++) {
				q = p;
				p = p.next;
			}
			if (p.next == null) {
				System.out.println("position not found, delete not posible ");
			} else {
				q.next = p.next;
				System.out.println("Delete node information");
			}
		}
	}

	public static void reverse() {
		Node q = start.next;
		Node p = start.next;
		start.next = null;
		while (q != null) {
			p = q;
			q = q.next;
			p.next = start;
			start = p;
		}
		System.out.println("Linkedlist reversed");
	}

	public static void display() {
		Node p = start;
		if (start == null) {
			System.out.println("empty linked list");
		} else {
			System.out.println("Node details**** ");
			while (p != null) {
				System.out.println(p.info + "---------");
				p = p.next;
			}
		}
	}

	public static void main(String[] args) {
		while (true) {
			System.out.print("\n*MENU");
			System.out.print("0:Exit");
			System.out.print(" ,1:Creation");
			System.out.print(" ,2:Insert at Beginning");
			System.out.print(" ,3:Insert at End");
			System.out.print(" ,4:Insert at any Position");
			System.out.print(" ,5:Delete at Beginning");
			System.out.print(" ,6:Delete at End");
			System.out.print(" ,7:Delete at any Position");
			System.out.print(" ,8:Display");
			System.out.print(" ,9:Reverse");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {
				case 0:
					System.exit(0);
				case 1:
					create();
					break;
				case 2:
					InsBeg();
					break;
				case 3:
					InsEnd();
					break;
				case 4:
					InsAny();
					break;
				case 5:
					DelBeg();
					break;
				case 6:
					DelEnd();
					break;
				case 7:
					DelAny();
					break;
				case 8:
					display();
					break;
				case 9:
					reverse();
					break;
				default:
					System.out.println("Wrong choice");

			}
		}
	}
}