package programmers;

import java.util.Stack;

public class 괄호회전 {
    public static void main(String[] args) {
        String s = "[](){}";
        int answer = 0;

        if (s.length()%2 !=0){
            answer = 0;
        }
        else {
            for (int i=0; i<s.length(); i++){
                Stack<Character> stack = new Stack<>();
                String str = s.substring(i, s.length()) + s.substring(0,i);
                for (int j=0; j<s.length(); j++){
                    char c = str.charAt(j);
                    if (stack.isEmpty()){
                        stack.push(c);
                    }
                    else if(c==')'&& stack.peek() =='('){
                        stack.pop();
                    }
                    else if(c=='}'&& stack.peek() =='{'){
                        stack.pop();
                    }
                    else if(c==']'&& stack.peek() =='['){
                        stack.pop();
                    }
                    else {
                        stack.push(c);
                    }
                }
                if (stack.isEmpty()){
                    answer ++;
                }
            }

        }




    }
}
