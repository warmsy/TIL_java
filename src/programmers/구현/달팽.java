package programmers.구현;

import java.util.Scanner;

public class 달팽 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        // 값을 담아 줄 준비
        int k =1; // 배열 안에 담아 줄 수
        int round = 1; // 진행 회차
        int x=0,y = 0;  // 시작 좌표

        if (n % 2 == 1) {
            arr[n/2][n/2] = n*n;
        }

        while (k< n*n){
            // 1. 오른쪽 진행
            // n이 5라 치면 4니까 인덱스 0~3까지 총 4번 진행
            for (int j = y; j<n-round; j++){
                arr[x][j] = k;
                k++;
                y++;
            }

            // 2. 아래로 진행
            for (int i=x; i<n-round; i++){
                arr[i][y] = k;
                k++;
                x++;
            }

            // 3. 왼쪽 진행, 4~1 총 4번
            for (int j = y; j > round - 1; j--) {
                arr[x][j] = k;
                k++;
                y--;
            }

            // 4. 위로 진행
            for (int i = x; i > round - 1; i--) {
                arr[i][y] = k;
                k++;
                x --;
            }
//            System.out.println("x "+x);
//            System.out.println("y "+y);
//            System.out.println("round "+round);
//            System.out.println("k " + k);
            x = round;
            y=round;
            round += 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }










    }
}
