package backjoon;

import java.util.Scanner;

public class 스티커9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int rows = 2;
            int cols = sc.nextInt();
            int[][] stickers = new int[rows][cols + 1];
            int[][] dp = new int[rows][cols + 1];

            // sticker 초기화 해주기
            for (int j = 0; j < rows; j++) {
                for (int k = 1; k <= cols; k++) {
                    stickers[j][k] = sc.nextInt();
                }
            }
            // dp 테이블 초기값 세팅해주기
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            // dp 순회하면서 값 채워주기
            for (int a = 2; a <= cols; a++) {
                // 첫쨰 열의 a값은 sticker에서의 a값에
                // 대각선 아래의 값과 그 옆에 값 중 큰 수
                dp[0][a] = stickers[0][a]
                        + Math.max(dp[1][a - 1], dp[1][a - 2]);
                dp[1][a] = stickers[1][a]
                        + Math.max(dp[0][a - 1], dp[0][a - 2]);

            }
            int maxScore = Math.max(dp[0][cols], dp[1][cols]);
            System.out.println(maxScore);
        }

    }
}
