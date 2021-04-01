package BinaryTree;

import java.util.*;

public class BinarySearchTreeUsingLinkedList {
  private class Node {
    Node right;
    Node left;
    int data;

    Node(int data) {
      this.data = data;
    }
  }

  private Node root;

  private static Scanner sc = new Scanner(System.in);

  private boolean checkForEmptyTree() {
    if (root == null) {
      System.out.println("There is no Tree created");
      return true;
    }
    return false;
  }

  private void insertNode(Node node, int value) {
    if (root == null) {
      root = new Node(value);
      System.out.println("Created new tree and inserted the node " + root.data);
      return;
    }
    if (value < node.data) {
      if (node.left != null) {
        insertNode(node.left, value);
      } else {
        node.left = new Node(value);
        System.out.println("inserted node in the left of" + node.data + "");
      }
    } else if (value > node.data) {
      if (node.right != null) {
        insertNode(node.right, value);
      } else {
        node.right = new Node(value);
        System.out.println("inserted the node to right of" + node.data);
      }
    }
  }

  private void searchElement(Node node, int value) {
    if (node == null) {
      return;
    } else if (node.data == value) {
      System.out.println("Element Found " + node.data);
      return;
    } else {
      if (value < node.data) {
        searchElement(node.left, value);
      } else if (value > node.data) {
        searchElement(node.right, value);
      } else {
        System.out.println("Element Not found");
        return;
      }
    }
  }

  // *** Different Methods of traversal *****/

  private void preOrderTraversal(Node node) {
    if (node == null)
      return;
    System.out.print(node.data);
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
  }

  private void inOrderTraversal(Node node) {
    if (node == null)
      return;
    inOrderTraversal(node.left);
    System.out.print(node.data + " ");
    inOrderTraversal(node.right);
  }

  private void postOrderTraversal(Node node) {
    if (node == null)
      return;
    postOrderTraversal(node.left);
    postOrderTraversal(node.right);
    System.out.print(node.data + " ");
  }

  private void levelOrderTraversal(Node node) {
    if (checkForEmptyTree())
      return;
    Queue<Node> queue = new LinkedList<>();
    if (node == null)
      return;
    queue.add(root);
    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.data + " ");
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  public Node deleteNode(Node node, int value) {
    if (root == null) {
      return null;
    }

    if (value < node.data) {
      node.left = deleteNode(node.left, value);
    } else if (value > node.data) {
      node.right = deleteNode(node.right, value);
    } else {
      System.out.println(node.data);
      if (node.left != null && node.right != null) {
        Node temp=node.right;
        Node minRightSubTree= minimumRightSubtree(temp);
        // System.out.println(temp.data);
        node.data = minRightSubTree.data;
        deleteNode(node.right, minRightSubTree.data);

      } else if (node.right == null) {
        node = node.left;
      } else if (node.left == null) {
        node = node.right;
      } else {
        return null;
      }
    }
    return node;
  }

  private Node minimumRightSubtree(Node node) {
    System.out.println("finding minimmum"+node.data);
    if (node.left == null)
      return node;
      // System.out.println(node.data);
     return minimumRightSubtree(node.left);
  }

  public static void main(String[] args) {
    System.out.println("Create your linked List");
    System.out.println("1.) Press 1 to Insert a Node");
    System.out.println("2.) Press 2 to DELETE NODE");
    System.out.println("3.) Press 3 to SEARCH a node");
    System.out.println("4.) Press 4 to PRINT IN PRE-ORDER TRAVERSAL");
    System.out.println("5.) Press 5 to PRINT IN IN-ORDER TRAVERSAL");
    System.out.println("6.) Press 6 to PRINT IN POST-ORDER TRAVERSAL");
    System.out.println("7.) Press 7 to PRINT IN LEVEL-ORDER TRAVERSAL");
    System.out.println("9.) Press 9 to Exit");
    System.out.print("Enter Your Choice : ");

    BinarySearchTreeUsingLinkedList bst = new BinarySearchTreeUsingLinkedList();

    int choice = sc.nextInt();
    int value;
    while (choice != 9) {
      switch (choice) {

      case 1: {
        System.out.println("Enter the value of the node");
        value = sc.nextInt();
        bst.insertNode(bst.root, value);
        break;
      }
      case 2: {
        System.out.println("Enter the value to be deleted");
        value = sc.nextInt();
        bst.deleteNode(bst.root, value);
        break;
      }
      case 3: {
        System.out.println("Enter the element tob e searched");
        value = sc.nextInt();
        bst.searchElement(bst.root, value);
        break;
      }
      case 4: {
        bst.preOrderTraversal(bst.root);
        break;
      }
      case 5: {
        bst.inOrderTraversal(bst.root);
        break;
      }
      case 6: {
        bst.postOrderTraversal(bst.root);
        break;
      }
      case 7: {
        bst.levelOrderTraversal(bst.root);
        break;
      }
      default:

        System.out.print("\nEnter Correct Choice : 1,2,3,4,5,6");
        break;
      }
      System.out.print("\nEnter Your Choice : ");
      choice = sc.nextInt();
    }
  }

}
