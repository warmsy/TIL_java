package SSAFY.STUDY;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 모험가길드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // desc 로는 불가능한강? -> 가능은 한데 collections.reverseOrder 써야되서 좀 복잡

        int answer = 0;
        int p = 0;
        for (int f : arr) {
            p++;
            if (f <= p) {
                answer++;
                p = 0;
            }
        }
        System.out.println(answer);
    }
}
