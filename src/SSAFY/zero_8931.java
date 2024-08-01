package SSAFY;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class zero_8931 {// stack도 초기화

// cnt도 static으로 초기화 해줘야되나?

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/CodingTest/res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1. TestCase 받아오기
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        // 처음에 T개 받아오는데
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            // 2. stack 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                // a 받아오는데
                int a = Integer.parseInt(st.nextToken());
                // stack 비어있지않고 0이 아니면 넣어주고
                if (a == 0) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else { // a가 0 아닐 때
                    stack.push(a);
                }
            }
            int answer = 0;
            while (!stack.isEmpty()) {
                answer += stack.pop();
            }


            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}