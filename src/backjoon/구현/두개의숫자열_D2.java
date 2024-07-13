package backjoon.구현;

import java.util.Scanner;

public class 두개의숫자열_D2 {
    private static int findTotal(int max, int min, int[] big, int[] small) {
        int total = 0;
        int maxTotal = 0;
        int cnt = 0;
        while (cnt < max - min + 1) {
            for (int i = 0; i < min; i++) {
                total += small[i] * big[i + cnt];
            }
            maxTotal = Math.max(total, maxTotal);
            total = 0;
            cnt++;
        }
        return maxTotal;
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] n = new int[N];
            int[] m = new int[M];
            int maxTotal = 0;

            // 배열 초기화
            for (int i = 0; i < N; i++) {
                n[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                m[i] = sc.nextInt();
            }
            // N, M 배열 크기 동일
            if (N == M) {
                for (int i = 0; i < N; i++) {
                    maxTotal += n[i] * m[i];
                }
                System.out.println("#"+test_case+" " + maxTotal);
            }
            // N, M 크기 다름
            else {
                if (M > N) {
                    System.out.println("#"+test_case+" " + findTotal(M, N, m, n));
                } else {
                    System.out.println("#"+test_case+" " + findTotal(N, M, n, m));
                }
            }

        }

    }

}
