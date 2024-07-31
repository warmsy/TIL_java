package SSAFY;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class zero_8931 {
    // stack도 초기화
    private static Stack<Integer> stack;
    // cnt도 static으로 초기화 해줘야되나?

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("scr/CodingTest/res/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1. TestCase 받아오기
        int T = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        // 처음에 T개 받아오는데
        for (int tc = 1; tc <= T; tc++) {
            // 개수를 받아오겠구나
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            // 2. stack 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                stack.push(a);
            }
            int cnt = 0;
            // 3. stack iterator 돌면서
            while (!stack.isEmpty()) {
                if (stack.pop() == 0) {
                    cnt++;
                    zeroSum(cnt);
                } else {

                }
            }


        }


    }

    private static void zeroSum(int cnt) {
        if (cnt != 0) {
            zeroSum(cnt++);
        } else {
            stack.pop();
            cnt--;
        }

    }
}