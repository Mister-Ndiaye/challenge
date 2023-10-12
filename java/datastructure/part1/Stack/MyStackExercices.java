package part1.Stack;

import java.util.Arrays;
import java.util.Stack;

public class MyStackExercices {

    private String openingBrackets = "{(<[";
    private String closingBrackets = "})>]";
    public String reverseString(){
        String str = "abcd";
        java.util.Stack stack = new java.util.Stack<>();
        String [] list = str.split("");
        for (int i = 0; i < list.length; i++) {
            stack.push(list[i]);
        }
        return Arrays.toString(list);
    }
    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack();
        for(char ch : input.toCharArray()){
            if(openingBrackets.indexOf(ch)>0){
                stack.push(ch);
            } else  if(closingBrackets.indexOf(ch)>0){
                if (closingBrackets.indexOf(ch)!=openingBrackets.indexOf(stack.pop()))
                    return false;
            }
        }
        return stack.size()<=0;
    }
    public static void main(String[] args) {
  String p = "hello";
        MyStackExercices stack = new MyStackExercices();
        //System.out.println( stack.reverseString());
        System.out.println(stack.isBalanced("((1+2))}"));
    }
}
