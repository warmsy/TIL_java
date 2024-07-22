package swea.구현;

import java.util.Scanner;

public class D2_간단한압축풀기_1946 {
    public static void main(String[] args) {
        // 1. 테케 받아오기
        // 2. N으로 받아오고 StringBuilder 써서 append 하기
        // 3. 출력할 떄는 subString 으로 잘라서 출력하기

        Scanner sc = new Scanner(System.in);

        final int T = sc.nextInt();
        StringBuilder sb;
        int total;
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            sb = new StringBuilder();
            total = 0;
            for (int i = 0; i < N; i++) {
                String alpha = sc.next();
                int repeat = sc.nextInt();
                total += repeat;

                for (int j = 0; j < repeat; j++) {
                    sb.append(alpha);
                }
            }

            int repeat = total / 10;
            int last = total % 10;

            for (int i = 0; i < total-10; i+=10) {
                System.out.println(sb.substring(i,i+10));
            }
            System.out.println(sb.substring(total-last));
        }
    }
}
