package Queue;

import java.util.Scanner;

public class LinearQueueUsingLinkedList{
    static Scanner sc =new Scanner(System.in);

    class Node{
        int data;
        Node next;
        Node(int data){
            data=this.data;
        }
    }
    Node head,tail,temp;

    private void enQueue(){

    }
    private void deQueue(){

    }
    private void peekInQueue(){

    }
    private void deleteQueue(){

    }
    private void printQueue(){

    }


    public static void main(String[] args) {
        int choice;
        LinearQueueUsingLinkedList lq = new LinearQueueUsingLinkedList();

        System.out.println("1) Creation of the Queue");
        System.out.println("2) ENQUEUE to Queue");
        System.out.println("3) DEQUEUE to Queue");
        System.out.println("4) PeekInQueue the Queue");
        System.out.println("5) Delete the Queue");
        System.out.println("6) Print  the Queue");
        System.out.println("9)Exit from the program ");

        System.out.println("Enter your choice");
        choice = sc.nextInt();
        while (choice != 9) {
            switch (choice) {
                case 1:
                    break;
                case 2:
                    lq.enQueue();
                    break;
                case 3:
                    lq.deQueue();
                    break;
                case 4:
                    lq.peekInQueue();
                    break;
                case 5:
                    lq.deleteQueue();
                    break;
                case 6:
                    lq.printQueue();
                    break;

                default:
                    System.out.println("Enter your Choice as 1,2,3,4,5,6,9");
                    break;
            }
            System.out.print("\nEnter Your Choice ");
            choice = sc.nextInt();
        }

        sc.close();
    }
}