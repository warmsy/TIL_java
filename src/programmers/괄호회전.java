package programmers;


import java.util.Stack;

public class 괄호회전 {
    public static void main(String[] args) {
        String s = "[]{}()";
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, s.length()) + s.substring(0, i);
            System.out.println(str);
            stack.add(str.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                if (str.charAt(j) == ')' && stack.peek()=='(') {
                    stack.pop();
                } else if (str.charAt(j) == '}' && stack.peek()=='{') {
                    stack.pop();
                } else if (str.charAt(j) == ']' && stack.peek()=='[') {
                    stack.pop();
                } else {
                    stack.add(str.charAt(j));
                }
            }
            if (stack.isEmpty()){
                answer++;
                System.out.println("answer");
            }
            stack.clear();
        }
        System.out.println(answer);
    }


}

