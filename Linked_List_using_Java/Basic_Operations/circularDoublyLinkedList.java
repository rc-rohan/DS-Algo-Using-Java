import java.util.Scanner;

public class circularDoublyLinkedList {
    private class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    private static Node head, tail, temp;
    static Scanner sc = new Scanner(System.in);

    private boolean checkForCDLL(){
        if(head==null){
            System.err.println("Linked List doesn't exists");
            return false;
        }
        return true;
    }

    private void insertNode(){
        int length=0,loc,data;
        System.out.println("enter the data");
        data=sc.nextInt();
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            newNode.prev=head;
            newNode.next= head;
            System.out.println("Created a new Linked list");
        }else{
            System.out.println("enter the location for insertion of the,inked list");
            loc=sc.nextInt();
            if(loc==0){
                newNode.next=head;
                head.prev = newNode;
                newNode.prev = tail;
                head = newNode;
                tail.next =head;
                System.out.println("Enterd the new Node at First Position");
                return ;
            }
            Node prevNode=head;
            for(temp = head; temp.next!=head ;temp=temp.next){
                if(length==loc){
                    break;
                }
                length++;
                prevNode=temp;
            }
            if(temp.next==head){
                temp.next = newNode;
                newNode.prev = temp;
                tail = newNode;
                newNode.next=head;
                head.prev = newNode;
                System.out.println("Added new Node at Last Positon");
                return;
            }else{
                newNode.prev=prevNode;
                newNode.next=prevNode.next;
                prevNode.next = newNode;
                temp.prev = newNode;
                System.err.println("Inserted the new Node at position "+loc);
                return;
            }

        }
    }
    private void deleteNode(){
        int loc,length=0;
        Node prevNode;
        boolean check  = checkForCDLL();
        if(!check){
            return;
        }

        System.out.println("Enter the Location of Node to be DELETED");
        loc = sc.nextInt();
        temp =head;
        if(loc==0){
            head = head.next;
            head.prev = tail;
            tail.next=head;
            temp.next=null;
            temp.prev=null;
            System.out.println("Delted the Node at the First Position");
            return;
        }
        prevNode = head;
        while(temp.next!=head){
            if(length==loc){
                break;
            }
            length++;
            prevNode=temp;
            temp=temp.next;
        }
        if(temp.next==head){
            prevNode.next = head;
            tail = prevNode;
            temp.prev=null;
            temp.next=null;
            System.out.println("Deleted the last Node of the CDLL");
        }else{
            prevNode.next = temp.next;
            temp.next.prev = prevNode;
            temp.prev= null;
            temp.next = null;
            System.out.println("Deleted the Node at the loc "+loc);
        }
        return;

    }

    private void deleteEntireList() {
        boolean check = checkForCDLL();
        if(!check){
            return;
        }
        head=null;
        tail= null;
        temp=null;
        System.out.println("Deleted the entire Linked List");

    }
    private void printLinkedListReverse(){
        boolean check = checkForCDLL();
        if(!check){
            return;
        }
        System.out.print(tail.data+" ");
        for(temp=tail.prev;temp!=tail;temp=temp.prev){
            System.out.print(temp.data+" ");
        }

    }
    private void printLinkedList(){
        boolean check = checkForCDLL();
        if(!check){
            return;
        }
        System.out.print(head.data+" ");
        for(temp = head.next;temp!=head;temp=temp.next){
            System.out.print(temp.data+" ");
        }
    }


    public static void main(String[] args) {

        circularDoublyLinkedList cdll = new circularDoublyLinkedList();

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
                    cdll.insertNode();
                    break;
                }
                case 2: {
                    cdll.deleteNode();
                    break;
                }
                case 3: {
                    // System.out.println();
                    break;
                }
                case 4: {
                    cdll.deleteEntireList();
                    break;
                }
                case 5: {
                    cdll.printLinkedList();
                    break;
                }
                case 6: {
                    cdll.printLinkedListReverse();
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
