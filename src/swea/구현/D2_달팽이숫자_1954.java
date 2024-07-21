package swea.구현;

import java.util.*;

public class D2_달팽이숫자_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n;
        int[][] arr;
        int round; // 몇 바퀴째 돌고있는지?
        int currentC; // 현재 열 위치는 어디?
        int currentR; // 현재 행 위치는 어디?
        int cnt; // 몇 번째 돌고있는지?

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt(); // 테스트 케이스마다 n크기 받아오기
            arr = new int[n][n];
            cnt = 1;
            currentR = 0;
            currentC = 0;
            round = 1;
            while (cnt <= n * n) {
                // to Right
                // 1. 시작 위치 반영 2. 현재 몇번째 회전인지
                for (int j = currentC; j <= n - round; j++) {
                    arr[currentR][j] = cnt++;
                    currentC = j; // 현재 열 위치 반영
                }
                currentR++; // 행 위치 반영

                // to down
                for (int i = currentR; i <= n - round; i++) {
                    arr[i][currentC] = cnt++;
                    currentR = i;
                }
                currentC--;

                // to left
                for (int j = currentC; j >= round - 1; j--) {
                    arr[currentR][j] = cnt++;
                    currentC = j;
                }
                currentR--;
                
                // 마지막 범위 주의!! 옆으로 꺾여야댐!!
                for (int i = currentR; i >= round; i--) {
                    arr[i][currentC] = cnt++;
                    currentR = i;
                }
                currentC++;
                // 다 돌았으니까 round 키워주기
                round++;

            }
            System.out.println("#" + tc);
            for (int[] i : arr) {
                for (int j : i) {
                    System.out.print(j+" ");
                }
                System.out.println();
            }

        }


    }
}
