package part2.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trees {
    private Node root;
    private int length;
    private List<Integer> deepth = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void add(int item) {
        Node node = new Node(item);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;

        while (true) {
            if (current.value < item) {
                if (current.leftChild != null)
                    current = current.leftChild;
                else {
                    current.leftChild = node;
                    break;
                }
            }
            if (current.value > item)
                if (current.rightChild != null)
                    current = current.rightChild;
                else {
                    current.rightChild = node;
                    break;
                }
        }

    }

    public List<Integer> breadthFirstLevelOrder(Node node) {
        Node current = root;
        List<Integer> tree = new ArrayList<>();

        return null;
    }

    private boolean isLeafNode(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public Node addRecursive(Node current, Node newNode) {

        if (newNode.value < current.value) {
            if (current.leftChild == null) {
                current.leftChild = newNode;
                return newNode;
            }
            return addRecursive(current.leftChild, newNode);
        }
        if (newNode.value > current.value) {
            if (current.rightChild == null) {
                current.rightChild = newNode;
                return newNode;
            }
            return addRecursive(root.leftChild, newNode);
        }
        return null;
    }

    public void recursive(Node node) {
        if (node == null)
            return;
        list.add(node.value);
        recursive(node.leftChild);
        recursive(node.rightChild);
    }

    public String toArray() {
        recursive(root);
        return list.toString();
    }

    public void getHeight() {
        getHeight(root.leftChild);
        System.out.println(length);
        length = 0;
        getHeight(root.rightChild);
        System.out.println(length);
    }

    public void getHeight(Node node) {
        if (!isNotNull(node))
            return;
        length++;

        if (isLeafNode(node))
            deepth.add(length);

        getHeight(node.rightChild);
        getHeight(node.leftChild);
        System.out.println(deepth.toString());
    }

    private boolean isNotNull(Node node) {
        return node != null;
    }

    public boolean contains(int item) {
        var current = root;
        while (current != null) {
            if (current.value < item)
                current = current.leftChild;
            else if (current.value > item)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    private class Node {
        Node(int value) {
            this.value = value;
        }

        private int value;
        private Node leftChild;
        private Node rightChild;

    }
    public static Map<String, Object> getValues() {
        return null;
    }


    public static void main(String[] args) {
        var x = getValues();
        Trees trees = new Trees();
        trees.add(7);
        trees.add(4);
        trees.add(9);
        trees.add(1);
        trees.add(6);
        trees.add(8);
        trees.add(10);
        trees.getHeight();
        System.out.println(trees.contains(110));
        System.out.println(trees.toArray());

    }


}
