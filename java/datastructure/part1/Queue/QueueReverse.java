package part1.Queue;



import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverse {

    public void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue);
        QueueReverse queueReverse = new QueueReverse();
        queueReverse.reverse(queue);
    }
}
