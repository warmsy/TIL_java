package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 값 받아주기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] woods = new int[n];
        // 굳이 따지자면 정렬할 필요 없이 최댓값만을 구해주면 됨.
        int max = 0;
        for (int i = 0; i < n; i++) {
            woods[i] = sc.nextInt();
            max = Math.max(max, woods[i]);
        }
        int min =0; // 최솟값

        while (min <= max) {
            int mid = (min + max) / 2;
            long cutWood = 0;
            // 여기가 문제였구나.. m의 크기가 int의 초과범위에 거의 근접해서..
            // 자른 나무의 합을 long 타입으로 받아줘야 넉넉하게 할 수 있구나..
            for (int tree : woods) {
                if (tree >= mid) {
                    cutWood += (tree - mid);
                }
            }
            if (cutWood >= m) {
                min = mid + 1;
            } else max = mid-1;
        }
        System.out.println(max);
    }
}
