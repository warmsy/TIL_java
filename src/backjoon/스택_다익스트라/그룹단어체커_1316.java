package backjoon.스택_다익스트라;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 그룹단어체커_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            char [] chars = br.readLine().toCharArray();
            stack.push(chars[0]);
            for (char c : chars) {
                if (c == stack.peek()) {
                    stack.pop();
                    stack.push(c);
                } else stack.push(c);
                set.add(c);
            }
            if (set.size() == stack.size()) cnt ++;
            stack.clear();
            set.clear();
        }
        System.out.println(cnt);

    }

}
