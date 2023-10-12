package part1.Stack;

import java.util.Arrays;

public class Stack {
    private int [] list = new int [5];
    private int count =0;

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    public void push(int item){
        if (count==list.length){
            int [] newList = new int[2*count];
            for (int i = 0; i <count ; i++) {
                newList[i]=list[i];
            }
            list=newList;
        }
        list[count++] = item;
    }
    public int pop(){
        return list[count--];
    }
    public int peek(){
        return list[count];
    }
    public int size(){
        return count;
    }
    public void display(){
        int [] newList = new int[count];
        for (int i = 0; i <count ; i++) {
            newList[i]=list[i];
        }
        System.out.println(Arrays.toString(newList));
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(20);
        stack.push(20);
        stack.push(20);
        stack.push(20);
        stack.push(30);
        //stack.pop();
        stack.display();

    }
}
