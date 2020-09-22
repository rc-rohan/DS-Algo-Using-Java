import java.util.Scanner;
public class StackUsingLinkedList {
    static Scanner sc  = new Scanner(System.in);

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
        }
    }
    Node head,temp;


    private boolean isEmpty(){
        if(head==null){
            System.out.println("Stack is EMPTY");
            return true;
        }
        return false;
    }
    private void push(){
        int data;
        System.out.println("Enter the data for the element");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(head==null){
            System.out.println("Creating the Linked List");
            head=newNode;
        }else{
            newNode.next = head;
            head = newNode;
            System.out.println("PUSHED element to the top of the stack");
        }
    }
    private void pop(){
        boolean check  = isEmpty();
        if(check){
            return;
        }
        temp = head;
        head = head.next;
        System.out.println("Element POPED from the stack is " +temp.data);
        temp.next = null;
    }
    private void peek(){
        boolean check = isEmpty();
        if(check){
            return;
        }
        System.out.println("Element at the Top Of Stack is "+head.data);
    }
    private void delete(){
        boolean check = isEmpty();
        if(check){
            return;
        }
        System.out.println("DELETING the entire STACK");
        head=null;
        temp=null;
    }

    private void printStack(){
        boolean check = isEmpty();
        if(check){
            return;
        }
        for(temp=head;temp!=null;temp = temp.next){
            System.out.print(temp.data+" ");
        }
    }

    public static void main(String[] args) {
        int choice;

        StackUsingLinkedList stack = new StackUsingLinkedList();

        System.out.println("1.) PUSH element to the Stack");
        System.out.println("2.) POP element from Stack");
        System.out.println("3.) PEEK elements of Stack");
        System.out.println("4.) DELETE a Stack");
        System.out.println("5.) Check whether stack is empty");
        System.out.println("6.) Print the stack");
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
                    boolean check = stack.isEmpty();
                    System.out.println(check);
                    break;
                case 6:
                    stack.printStack();
                    break;

                default:
                    break;
            }
            System.out.print("\nEnter your choice for operation ");
            choice = sc.nextInt();
        }
        sc.close();
    }
}
