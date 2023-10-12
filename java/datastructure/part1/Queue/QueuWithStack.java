package part1.Queue;

import java.util.Stack;

public class QueuWithStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void enqueu(int item){
        stack1.add(item);
    }
    public void dequeu(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        stack2.pop();
    }
}
