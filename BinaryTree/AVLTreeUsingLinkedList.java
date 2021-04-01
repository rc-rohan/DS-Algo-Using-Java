package BinaryTree;

import java.util.*;
import java.math.*;

public class AVLTreeUsingLinkedList {

  public class Node {
    int value, height;
    Node left, right;

    Node(int value, int height) {
      this.value = value;
      this.height = height;
    }
  }

  private Node root;
  private static Scanner sc = new Scanner(System.in);

  private int updateHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max((node.left != null ? node.left.height : -1), (node.right != null ? node.right.height : -1));
  }

  private Node leftRotate(Node node) {
    // rotating the nodes
    Node newNode = node.right;
    node.right = node.right.left;
    newNode.left = node;

    // re calculating the height of the node
    node.height = updateHeight(node);
    newNode.height = updateHeight(newNode);

    return newNode;
  }

  private Node rightRotate(Node node) {
    Node newNode = node.left;
    node.left = node.left.right;

    newNode.right = node;

    node.height = updateHeight(node);
    newNode.height = updateHeight(node);

    return newNode;
  }

  private int checkBalance(Node leftNode, Node rightNode) {
    if (leftNode == null && rightNode == null) {
      return 0;
    } else if (leftNode == null) {
      return -1 * (rightNode.height + 1);
    } else if (rightNode == null) {
      return leftNode.height + 1;
    } else {
      return leftNode.height - rightNode.height;
    }
  }

  private Node insertNode(Node node, int value) {
    if (node == null) {
      // System.out.println("Created new tree and inserted the value to root");
      return new Node(value, 0);
    } else if (value < node.value) {
      node.left = insertNode(node.left, value);
    } else {
      node.right = insertNode(node.right, value);
    }

    int balance = checkBalance(node.left, node.right);

    if (balance > 1) {
      if (checkBalance(node.left.left, node.left.right) > 0) {
        node = rightRotate(node);
      } else {
        node.left = leftRotate(node.left);
        node = rightRotate(node);
      }
    } else if (balance < -1) {
      if (checkBalance(node.right.right, node.right.left) > 0) {

        node = leftRotate(node);
      } else {
        node.right = rightRotate(node.right);
        node = leftRotate(node);
      }
    }
    node.height = updateHeight(node);

    return node;
  }

  private void preOrderTraversal(Node node) {
    if (node == null)
      return;
    System.out.print(node.value);
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
  }

  private void inOrderTraversal(Node node) {
    if (node == null)
      return;
    inOrderTraversal(node.left);
    System.out.print(node.value + " ");
    inOrderTraversal(node.right);
  }

  private void postOrderTraversal(Node node) {
    if (node == null)
      return;
    postOrderTraversal(node.left);
    postOrderTraversal(node.right);
    System.out.print(node.value + " ");
  }

  private void levelOrderTraversal(Node node) {

    Queue<Node> queue = new LinkedList<>();
    if (node == null)
      return;
    queue.add(root);
    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.value + " ");
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

    if (value < node.value) {
      node.left = deleteNode(node.left, value);
    } else if (value > node.value) {
      node.right = deleteNode(node.right, value);
    } else {
      System.out.println(node.value);
      if (node.left != null && node.right != null) {
        Node temp = node.right;
        Node minRightSubTree = minimumRightSubtree(temp);
        node.value = minRightSubTree.value;
        deleteNode(node.right, minRightSubTree.value);

      } else if (node.right == null) {
        node = node.left;
      } else if (node.left == null) {
        node = node.right;
      } else {
        return null;
      }
      return node;//if leaf node then no need to check the balance for that
    }

    int balance = checkBalance(node.left, node.right);
    if (balance > 1) {
      if ((checkBalance(node.left.left, node.left.right) > 0)) {
        node = rightRotate(node);
      } else {
        node.left = leftRotate(node.left);
        node = rightRotate(node);
      }
    } else if (balance < -1) {
      if ((checkBalance(node.right.right, node.right.left) > 0)) {
        node = leftRotate(node);
      } else {
        node.right = rightRotate(node.right);
        node = leftRotate(node);
      }
    }
    if (node.left != null) {
      node.left.height = (updateHeight(node.left));
    }
    if (node.right != null) {
      node.right.height = (updateHeight(node.right));
    }
    node.height = (updateHeight(node));

    return node;
  }

  private Node minimumRightSubtree(Node node) {
    System.out.println("finding minimmum" + node.value);
    if (node.left == null)
      return node;
    // System.out.println(node.value);
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

    AVLTreeUsingLinkedList avl = new AVLTreeUsingLinkedList();

    int choice = sc.nextInt();
    int value;
    while (choice != 9) {
      switch (choice) {

      case 1: {
        System.out.println("Enter the value of the node");
        value = sc.nextInt();
        avl.root = avl.insertNode(avl.root, value);
        break;
      }
      case 2: {
        System.out.println("Enter the value to be deleted");
        value = sc.nextInt();
        avl.root = avl.deleteNode(avl.root, value);
        break;
      }
      case 3: {
        System.out.println("this function is not vaid now");
        // value = sc.nextInt();
        // avl.searchElement(avl.root, value);
        break;
      }
      case 4: {
        avl.preOrderTraversal(avl.root);
        break;
      }
      case 5: {
        avl.inOrderTraversal(avl.root);
        break;
      }
      case 6: {
        avl.postOrderTraversal(avl.root);
        break;
      }
      case 7: {
        avl.levelOrderTraversal(avl.root);
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
