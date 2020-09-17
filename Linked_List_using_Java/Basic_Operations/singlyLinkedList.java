

import java.util.Scanner;

public class singlyLinkedList {

    private static Scanner sc = new Scanner(System.in);
    /*
     * We declare the "sc" as static beacause it will remain same for all the object
     */

    private class Node {
        int data;
        /*
         * Creating a user-defined variable(reference var) So that we can refer to the
         * data variable ahead in the code
         */
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node head, tail, temp;

    /* Checking For the linked list exists or not */
    private boolean checkForSLL() {
        if (head == null) {
            System.out.println("Linked List doesn't exists");
            return false;
        }
        return true;
    }

    private void insertNode() {
        int data, loc, length = 0;

        Node prev;

        System.out.println("Enter the value of the data");
        data = sc.nextInt();
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("Creating a LINKED LIST");
            head = newNode;
            tail = head;
            System.out.println("First element of the LINKED LIST is : " + newNode.data);
        } else {
            System.out.println("Enter the location for insertion of the linked list");
            loc = sc.nextInt();
            if (loc == 0) {
                newNode.next = head;
                head = newNode;
                System.out.println("Updated the Head of the Linked List");
                return;
            }
            prev=head;
            for (temp = head; temp.next != null; temp = temp.next) {
                if (length == loc) {
                    break;
                }
                length++;
                prev = temp;
            }
            if (temp.next == null) {
                temp.next = newNode;
                tail = newNode;
                System.out.println("Added a newnode a last position");
                return;
            } else {
                newNode.next = prev.next;
                prev.next = newNode;
                System.out.println("Added a new Node at position " + loc);
                return;
            }
        }
    }


    /* Deleting Node In the Linked List */
    private void deleteNode() {
        int loc, length = 0;
        Node prev;
        boolean existSLL = checkForSLL();

        if (!existSLL) {
            return;
        }
        System.out.println("Enter the Node Location to delete");
        loc = sc.nextInt();
        temp = head;
        if (loc == 0 || head==tail) {
            head = head.next;
            temp.next = null;
            System.out.println("Deleted the Node at : 1");
            return;
        }
        prev = head;
        for (temp = head; temp.next != null; temp = temp.next) {
            if (length == loc) {
                break;
            }
            length++;
            prev = temp;
        }
        if (temp.next == null) {
            tail = prev;
            prev.next = null;
            System.out.println("Deleted the Last Node of the List");
        } else {
            prev.next = temp.next;
            temp.next = null;
            System.out.println("Deleted the Node at : " + loc);
        }
        return;
    }

    private void deleteEntireList() {
        boolean check = checkForSLL();
        if (!check) {
            return;
        } else {
            head = null;
            temp = null;
            temp = null;
            System.out.println("Linked List Succesfuly Deleted");
        }
    }

    private void printLinkedList() {
        boolean check = checkForSLL();
        if (!check) {
            return;
        } else {

            for (temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        int choice;

        singlyLinkedList sll = new singlyLinkedList();

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
                    sll.insertNode();
                    break;
                }
                case 2: {
                    sll.deleteNode();
                    break;
                }
                case 3: {
                    // System.out.println();
                    break;
                }
                case 4: {
                    sll.deleteEntireList();
                    break;
                }
                case 5: {
                    sll.printLinkedList();
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
