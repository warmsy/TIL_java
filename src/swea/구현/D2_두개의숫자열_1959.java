package swea.구현;

import java.util.Scanner;

public class D2_두개의숫자열_1959 {
    /**
     * 잘한점
     * 반복되는 코드를 메서드로 뺸거
     * 디버깅 해서 코드 오류를 빠르게 파악하고 고친거
     *반성할 점
     * 중간에 수식 쓸 때 한번 더 검토하지 않은 것
     * total 값을 0으로 초기화 시키지 않은 것
     * 문제 푸는데 2시간 정도 걸린거.. 너무 느리다
     *개선점
     * 1. 전체 합계 구할거면 sum 이라 하고
     * 그 외에 다른 연산자가 들어가면 total 이라 하자.
     * 그래야 연산자 쓸 때 한번 더 체크 할 것 같다.
     * 2. findTotal 함수 짤 떄 시간이 오래걸렸다.
     * 사실 굳이 함수로 뺴지않고도 쉽게 풀수 있었는데.. 개선 코드 연습해야겠다.
     * 짧게 푸는 연습 하고.. 메모리 덜 잡아먹게 bufferReader 사용법 익히자.
     * */
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

/*다른사람 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            if (n > m) {
                int tmp = n;
                n = m;
                m = tmp;

                int[] tmpArr = a;
                a = b;
                b = tmpArr;
            }

            for (int i = 0; i <= m - n; i++) {
                int cur = 0;
                for (int j = 0; j < n; j++) {
                    cur += a[j] * b[i + j];
                }

                if (max < cur)
                    max = cur;
            }
            System.out.println("#" + t + " " + max);
        }
    }
}
*/
