import java.util.Scanner;
public class doublyLinkedList {

    private class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data=data;
        }
    }
    private static Node head,tail,temp;

    private static Scanner sc = new Scanner(System.in);

    private boolean checkForDLL(){
        if(head==null){
            System.out.println("Linked List does't exists");
            return false;
        }else{
            return true;
        }
    }
    private void insertNode() {
        int data,length = 0,loc;
        Node prevNode;
        System.out.println("Enter the Data of the Node");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(head==null){
            System.out.println("Creating Linked List");
            head = newNode;
            newNode.prev = null;
            newNode.next = null;
            tail = newNode;
        }else{

            System.out.println("Enter the location to insertion of the Node");
            loc = sc.nextInt();
            if(loc == 0){
                newNode.prev = null;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                System.out.println("Added new node at first position");
                return ;
            }
            prevNode = head;
            for(temp = head;temp.next!=null; temp = temp.next){
                if(length==loc){
                    break;
                }
                length++;
                prevNode = temp;
            }
            if(temp.next == null){
                temp.next  = newNode;
                newNode.prev = temp;
                tail = newNode;
                System.out.println("Enterd a new Node at Last");
                return;
            }else{
                newNode.prev = prevNode;
                newNode.next = prevNode.next;
                prevNode.next = newNode;
                temp.prev = newNode;
                System.out.println("Added an new Node at "+loc+" with data "+newNode.data);
            }
        }
    }


    private void deleteNode() {
        boolean check = checkForDLL();
        if(!check){
            return;
        }

        int loc, length = 0;
        Node prev;
        System.out.println("enter the Location of the Node");
        loc = sc.nextInt();
        temp = head;
        if(loc==0){
            head = head.next;
            temp.next = null;
            System.out.println("data of the deleted Node "+temp.data);
            head.prev = null;
            System.out.println("Deleted the first Node of the Linked List");
            return ;
        }
        prev = head;
        while(temp.next!=null){
            if(length==loc){
                break;
            }
            length++;
            prev = temp;
            temp=temp.next;
        }
        if(temp.next==null){
            prev.next = null;
            temp.prev = null;
            tail = prev;
            System.out.println("Deleted Node : "+temp.data);
            System.out.println("Deleted the Node At last Position");
            return;
        }else{
            prev.next=temp.next;
            temp.next.prev = prev;
            temp.prev = null;
            temp.next=null;
            System.out.println("Delted Node is "+temp.data);
            System.out.println("deleted the element at position "+loc);
            return;
        }
    }

    private void deleteEntireList() {
        boolean check = checkForDLL();
        if(!check){
            return;
        }
        head=null;
        tail=null;
        temp=null;
        System.out.println("Deleted the entire Linked List");
    }

    private void printLinkedListReverse(){
        boolean check = checkForDLL();
        if(!check){
            return;
        }
        for(temp =tail; temp!=null;temp = temp.prev){
            System.out.print(temp.data+"->");
        }
    }

    private void printLinkedList() {
        boolean check = checkForDLL();
        if (!check) {
            return;
        }
        for ( temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data+"->");
        }
    }


    public static void main(String[] args) {

        doublyLinkedList dll = new doublyLinkedList();

        System.out.println("Create your linked List");
        System.out.println("1.) Press 1 to ADD NODE");
        System.out.println("2.) Press 2 to DELETE NODE");
        System.out.println("3.) Press 3 to UPDATE NODE");
        System.out.println("4.) Press 4 to DELETE ENTIRE LINKED LST");
        System.out.println("5.) Press 5 to PRINT LINKED LIST");
        System.out.println("6.) Press 6 to PRINT LINKED LIST in REVERSE ORDER");
        System.out.println("9.) Press 9 to Exit");
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        while (choice != 9) {
            switch (choice) {

                case 1: {
                    dll.insertNode();
                    break;
                }
                case 2: {
                    dll.deleteNode();
                    break;
                }
                case 3: {
                    // System.out.println();
                    break;
                }
                case 4: {
                    dll.deleteEntireList();
                    break;
                }
                case 5: {
                    dll.printLinkedList();
                    break;
                }
                case 6: {
                    dll.printLinkedListReverse();
                    break;
                }
                default:

                    System.out.print("\nEnter Correct Choice : 1,2,3,4,5,6");
                    break;
            }
            System.out.print("\nEnter Your Choice : ");
            choice = sc.nextInt();

        }

        sc.close();
    }


}
