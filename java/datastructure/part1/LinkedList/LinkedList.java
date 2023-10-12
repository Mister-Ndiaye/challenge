package part1.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedList {
    private Node fist;
    private Node last;


    public LinkedList() {

    }

    class Node {
        int value;
        Node next;

        public Node(int item) {
            this.value = item;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (fist == null) {
            fist = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFist(int item) {
        Node node = new Node(item);
        if (fist == null) {
            fist = last = node;
        } else {
            node.next = fist;
            fist = node;
        }
    }

    public void deleteFist() {
        Node second = fist.next;
        fist.next = null;
        fist = second;
    }

    public void deleteLast() {
        Node current = fist;
        while (current != null) {
            if (current.next == last) {
                current.next = null;
                last = current;
            }
            current = current.next;
        }

    }

    public void display() {
        ArrayList arrayList = new ArrayList();
        Node current = fist;
        while (current.next != null) {
            arrayList.add(current.value);
            current = current.next;
        }
        arrayList.add(current.value);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    public LinkedList reverse() {

        Node current = fist;
        Node next = null;
        Node prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last = fist;
        fist = prev;
        return null;
    }

    public int getKthFromTheEnd(int k) {
        Node current = fist;
        Node targetNode = null;
        int endIndex = 0;
        while (current != null) {
            endIndex++;
            if (endIndex == k) {
                targetNode = fist;
            } else if (endIndex > k) {
                targetNode = targetNode.next;
            }
            current = current.next;

        }
        return targetNode.value;
    }

    public int printMiddle() {
        Node endPointer = fist;
        Node middlePointer = fist;
        while (endPointer != null && endPointer.next != null) {
            endPointer = endPointer.next.next;
            middlePointer = middlePointer.next;
        }
        if (endPointer == last)
            return middlePointer.value;

        return (endPointer.value + endPointer.next.value) / 2;
    }

    /**
     * Floyd’s Cycle-finding Algorithm
     *
     * @return
     */
    public boolean hasLoop() {
        Node fast = fist;
        Node slow = fist;

        while (fast != last && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * Floyd’s Cycle-finding Algorithm
     *
     * @return
     */
    public LinkedList createLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(60);
        linkedList.addLast(70);
        System.out.println(linkedList.printMiddle());
        //linkedList.reverse();
        linkedList.display();

    }
}
