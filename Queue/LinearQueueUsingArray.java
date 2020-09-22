import java.util.Scanner;

public class LinearQueueUsingArray {

    static Scanner sc = new Scanner(System.in);

    int queueArr[];
    int startOfQueue=0;
    int topOfQueue;

    LinearQueueUsingArray(){
        startOfQueue = 0;
        topOfQueue =-1;
    }


    private boolean isEmpty(){
        if(topOfQueue==-1){
            System.out.println("Queue is empty");
            return true;
        }
        return false;
    }
    private boolean isFull(){
        if(topOfQueue==queueArr.length-1){
            System.out.println("Queue is Full");
            return true;
        }
        return false;
    }

    private void createQueue() {
        int size;
        if(queueArr != null){
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
        boolean check = isFull();
        if(queueArr==null){
            System.out.println("First create the Queue");
            return;
        }
        if(check){
            return;
        }
        System.out.println("Enter data to ENQUEUE");
        data=sc.nextInt();
        queueArr[++topOfQueue]=data;
    }


	private void deQueue() {
        boolean check = isEmpty();
        if(check){
            return;
        }
        System.out.println("Element to be deQueued is "+queueArr[startOfQueue]);
        startOfQueue++;
        if(startOfQueue>topOfQueue){
            startOfQueue=0;
            topOfQueue=-1;
            System.err.println("This was the last element in the queue");
        }
    }

    private void peekInQueue() {
        boolean check = isEmpty();
        if(check){
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
        topOfQueue=-1;
        startOfQueue = 0;
    }

    private void printQueue() {
        boolean check  = isEmpty();
        if(check){
            return;
        }
        for(int i=startOfQueue;i<=topOfQueue;i++){
            System.out.print(queueArr[i]+" ");
        }

    }

    public static void main(String[] args) {
        int choice;
        LinearQueueUsingArray lq = new LinearQueueUsingArray();

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
                    lq.createQueue();
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