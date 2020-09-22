import java.util.Scanner;

public class StackUsingArray {

    static Scanner sc = new Scanner(System.in);

    static final int MAX = 1000;
    int stackArr[] = new int[MAX];
    int topOfStack = -1;// checks for the top value of the stack

    private boolean isFull() {
        if (stackArr.length == topOfStack) {
            System.err.println("Stack is Full");
            return true;
        }
        return false;

    }

    private boolean isEmpty() {
        if (topOfStack == -1) {
            System.out.println("Stack is EMPTY");
            return true;
        }
        return false;
    }

    private void push() {
        int data;
        boolean check = isFull();
        if (check) {
            return;
        }
        System.out.println("Enter the data to be PUSHED");
        data = sc.nextInt();
        stackArr[++topOfStack] = data;
        System.out.println("Data is pushed at " + topOfStack + " with value " + stackArr[topOfStack]);
        return;
    }

    private void pop() {
        boolean check = isEmpty();
        if (check) {
            return;
        }
        System.out.println("Removing the Element at the top of the stack " + stackArr[topOfStack]);
        stackArr[topOfStack] = 0;
        topOfStack--;
    }

    private void peek() {
        boolean check = isEmpty();
        if (check) {
            return;
        }
        System.out.println("Element ata top of the stack is" + stackArr[topOfStack]);
    }

    private void delete() {
        boolean check  = isEmpty();
        if(check){
            return;
        }
        System.out.println("Deleteing the entire array");
        stackArr = null;
    }

    private void printStack() {
        boolean check = isEmpty();
        if(check){
            return;
        }
        for(int i=topOfStack; i!=-1;i--){
            System.out.print(stackArr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int choice;

        StackUsingArray stack = new StackUsingArray();

        System.out.println("1.) PUSH element to the Stack");
        System.out.println("2.) POP element from Stack");
        System.out.println("3.) PEEK elements of Stack");
        System.out.println("4.) DELETE a Stack");
        System.out.println("5.) Check whether stack is Full");
        System.out.println("6.) Check whether stack is empty");
        System.out.println("9.) Press 9 to EXIT");
        System.out.println("Enter your Choice for the Operation");

        choice = sc.nextInt();
        while (choice != 9) {
            switch (choice) {

                case 1:
                    stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.delete();
                    break;
                case 4:
                    stack.peek();
                    break;
                case 5:
                    boolean check= stack.isFull();
                    System.out.println(check);
                    break;
                case 6:
                    check = stack.isEmpty();
                    System.out.println(check);
                    break;
                case 7:
                    stack.printStack();
                    break;

                default:
                System.out.println("Enter the choice as 1, 2,3,4,5,6,7,9");
                    break;
            }
            System.out.print("\n Enter your choice for operation ");
            choice = sc.nextInt();
        }
        sc.close();
    }

}