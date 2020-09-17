package Linked_List_using_Java.Basic_Operations;

import java.util.Scanner;

public class circularSinglyLinkedList {


    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private static Node head,tail,temp;

    private static Scanner sc = new Scanner(System.in);

    private boolean checkForCSLL(){
        if(head==null){
            System.out.println("Circular Linked List doesn't EXIST");
            return false;
        }else{
            return true;
        }
    }

    private void insertNode(){
        int data,loc,length=0;
        Node prev;
        System.out.println("Enter the data");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if(head==null){
            System.out.println("Creating the Linked List");
            head =  newNode;
            tail = newNode;
            newNode.next = head;
            System.out.println("Added a new node in the Linked List");
            return;
        }else{
            System.out.println("Enter the Location to Insert New Node");
            loc=sc.nextInt();
            if(loc==0){
                newNode.next = head;
                head=newNode;
                tail.next = newNode;
                System.out.println("Updated the first Node with data "+head.data);
                return;
            }

            prev = head;
            for(temp=head;temp.next!= head;temp=temp.next){
                if(length==loc){
                    break;
                }
                length++;
                prev=temp;
                System.out.println(length);
                System.out.println(temp.data+"->");
            }
            if(temp.next==tail.next){
                newNode.next = head;
                tail.next = newNode;
                System.out.println("Added a new Node at Last with data "+newNode.data);
                return ;
            }else{
                newNode.next = prev.next;
                prev.next = newNode;
                System.out.println("Entered New Node at: "+loc);
                return ;
            }
        }
    }


    private void printCSLL() {
        for(temp=head; temp.next!=tail.next ; temp=temp.next){
            System.out.print(temp.data+" ");
        }
        System.out.print(temp.data+" ");
    }


    public static void main(String[] args) {
        int choice;

        circularSinglyLinkedList csll = new circularSinglyLinkedList();

        System.out.println("Create your linked List");
        System.out.println("1.) Press 1 to ADD NODE");
        System.out.println("2.) Press 2 to DELETE NODE");
        System.out.println("3.) Press 3 to UPDATE NODE");
        System.out.println("4.) Press 4 to DELETE ENTIRE LINKED LST");
        System.out.println("5.) Press 5 to PRINT LINKED LIST");
        System.out.println("9.) Press 9 to Exit");
        System.out.print("Enter Your Choice : ");
        choice = sc.nextInt();
        while (choice != 9) {
            switch (choice) {

                case 1: {
                    csll.insertNode();
                    break;
                }
                case 2: {
                    // csll.deleteNode();
                    break;
                }
                case 3: {
                    // System.out.println();
                    break;
                }
                case 4: {
                    // csll.deleteEntireList();
                    break;
                }
                case 5: {
                    csll.printCSLL();
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
