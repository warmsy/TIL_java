package backjoon.스택_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        /* sudo 코드
         * 시간복잡도?
         * 1. 출력 개수 받기, stack 선언
         * 2. 명령을 담는 배열 만들어주기 -> 필요 없겠는데?
         * 3. 루프 돌면서 먼저 st로 받은 값을 명령어와 비교해주고 그에 따라 값 출력 (switch case)
         * */

//        for (int i = 0; i<num; i++) {
//            StringTokenizer st= new StringTokenizer(br.readLine());
//            String order = st.nextToken();
//            if (order.equals("push")) {
//                stack.push(Integer.parseInt(st.nextToken()));
//            } else if (order.equals("pop")) {
//                if (stack.isEmpty()) System.out.println(-1);
//                else System.out.println(stack.pop());
//            } else if (order.equals("size")) {
//                System.out.println(stack.size());
//            } else if (order.equals("empty")) {
//                if (stack.isEmpty()) System.out.println(1);
//                else System.out.println(0);
//            } else {
//                if (stack.isEmpty()) System.out.println(-1);
//                else System.out.println(stack.peek());
//            }
//        }
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop")) {
                if (stack.isEmpty())
                    sb.append(-1+"\n");
                else
                    sb.append(stack.pop()+"\n");
            } else if (order.equals("size")) {
                sb.append(stack.size()+"\n");
            } else if (order.equals("empty")) {
                if (stack.isEmpty())
                    sb.append(1+"\n");
                else
                    sb.append(0+"\n");
            } else {
                if (stack.isEmpty())
                    sb.append(-1+"\n");
                else
                    sb.append(stack.peek()+"\n");
            }
        }
        System.out.println(sb);
    }
}
