package hacker;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args){
        System.out.println(isBalanced("{[(])}"));
    }

    static String isBalanced(String s) {
        String openenrs = "({[";
        String closers = ")}]";
        int length = s.length();
        if (length % 2 != 0) {
            return "NO";
        }
        Stack<Character> stack = new Stack();
        int i = 0;
        for (i = 0; i < length ; i++) {
            if (openenrs.contains("" + s.charAt(i) + "")) {

                stack.push(s.charAt(i));
            }
            if (closers.contains("" + s.charAt(i) + "")) {
                if(stack.empty()){
                    return "NO";
                }
                char c = stack.pop();
                if(!checkBalance(c, s.charAt(i))){
                    return "NO";
                }
            }
        }
        if(stack.empty())
        return "YES";
        else
            return "NO";
    }

    private static boolean checkBalance(char c, char charAt) {
        boolean balance = false;
        if ((c == '{' && charAt == '}') || (c == '(' && charAt == ')') || (c == '[' && charAt == ']')) {
            balance = true;
        }
        return balance;
    }
}
