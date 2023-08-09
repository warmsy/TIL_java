package programmers;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "()()()())))(((((";
        boolean answer = solution(s);
        System.out.println(answer);
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 효율성테스트에서 실패했던 코드
     * 원인 분석 : 분기문이 너무 많아서 그런것 같다 추측.
     * 개선사항 : 분기처리를 더 깔끔하게 쓸 수 있도록 항상 유념하기.
     * 하나의 풀이에만 매몰되지 않을 것. 마스터키가 아님.
     * 다양한 풀이를 보며 피드백하자.
     */
    static boolean solutionTimeOver(String s) {
        if (s.charAt(0) == ')' || s.length() % 2 != 0)
            return false;

        else {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (stack.isEmpty()) stack.push(ch);
                else if (stack.peek() == '(' && ch == ')') stack.pop();
                else stack.push(ch);
            }
            return stack.isEmpty();
        }

    }

    /**
     * 질문하기에서 발견한 좋은 풀이
     * 한글자씩 체크하기 때문에 str.split("")로 String배열화 하여 사용하는 것보다 str.toCharArray()로 char배열을 사용하는것이 유리
     * Stack에 '(' 하나의 문자만 누적된다면 자료구조를 사용하지 않고 int변수에 갯수만 +/- 시키는 것이 유리
     */
    static boolean solutionGood1(String str) {
        int cntUnpair = 0;
        for (char ch : str.toCharArray()) {
            cntUnpair += ch == '(' ? 1 : -1;
            if (cntUnpair < 0) return false;
        }
        return cntUnpair == 0;
    }
    /**
     * 다른사람의 풀이
     * stack 만이 아니라 cnt를 사용해서도 풀 수 있음 아이디어 좋다.
     */
    boolean solutionGood2(String s) {
        boolean answer = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }
        if (count == 0) {
            answer = true;
        }

        return answer;
    }

}
