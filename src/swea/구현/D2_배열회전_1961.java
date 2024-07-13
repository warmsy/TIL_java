package swea.구현;

import java.util.Scanner;

public class D2_배열회전_1961 {
    public static void main(String args[])
    {   Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#"+test_case+" ");

            // 90도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[N - 1 - j][i]);
                }
                System.out.print(" ");

                // 180도
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[N - 1 - i][N - 1 - j]);
                }                  System.out.print(" ");

                // 270도

                for (int j = 0; j < N; j++) {
                    System.out.print(arr[j][N - 1 - i]);
                }

                System.out.println();
            }
        }
    }
}
