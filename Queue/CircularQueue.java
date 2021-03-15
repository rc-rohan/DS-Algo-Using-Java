package Queue;

import java.util.Scanner;

public class CircularQueue {

    static Scanner sc = new Scanner(System.in);

    int queueArr[];
    int startOfQueue;
    int topOfQueue;

    CircularQueue() {
        startOfQueue = 0;
        topOfQueue = -1;
    }

    private boolean isEmpty() {
        if (topOfQueue == -1) {
            System.out.println("Queue is empty");
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if (topOfQueue+1==startOfQueue) {
            System.out.println("Queue is Full");
            return true;
        }else if(startOfQueue==0 && topOfQueue==queueArr.length){
            System.out.println("Queue is full");
            return true;
        }
        return false;
    }

    private void createQueue() {
        int size;
        if (queueArr != null) {
            System.out.println("Queue is already created");
            return;
        }

        System.out.println("Enter the length of the queue");
        size = sc.nextInt();
        queueArr = new int[size];
        System.out.println("QUEUE created of the size " + size);

    }

    private void enQueue() {
        int data;
        if (queueArr == null) {
            System.out.println("First create the Queue");
            return;
        }else if (isFull()) {
            return;
        }else{
            System.out.println("Enter data to ENQUEUE");
            data = sc.nextInt();
            if(topOfQueue+1 == queueArr.length){
                topOfQueue = 0;
            }else{
                topOfQueue++;
            }
            queueArr[topOfQueue] = data;
            System.out.println("Enters the Data in the Array");
        }
    }

    private void deQueue() {
        boolean check = isEmpty();
        if (check) {
            return;
        }
        System.out.println("Element to be deQueued is " + queueArr[startOfQueue]);
        if(startOfQueue==topOfQueue){
            startOfQueue=0;
            topOfQueue=-1;
            System.out.println("this was the last element in th queue");
        }
        else if(startOfQueue == queueArr.length-1 ){
            startOfQueue=0;
        }
        else {
            startOfQueue++;
        }
    }

    private void peekInQueue() {
        boolean check = isEmpty();
        if (check) {
            return;
        }
        System.out.println(queueArr[startOfQueue]);
        return;
    }

    private void deleteQueue() {
        boolean check = isEmpty();
        if (check) {
            return;
        }
        System.out.println("Deleting the entire queue");
        queueArr = null;
        topOfQueue = -1;
        startOfQueue = 0;
    }

    private void printQueue() {
        boolean check = isEmpty();
        if (check) {
            return;
        }
        for (int i = startOfQueue; i <= topOfQueue; i++) {
            System.out.print(queueArr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int choice;
        CircularQueue cq = new CircularQueue();

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
                    cq.createQueue();
                    break;
                case 2:
                    cq.enQueue();
                    break;
                case 3:
                    cq.deQueue();
                    break;
                case 4:
                    cq.peekInQueue();
                    break;
                case 5:
                    cq.deleteQueue();
                    break;
                case 6:
                    cq.printQueue();
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