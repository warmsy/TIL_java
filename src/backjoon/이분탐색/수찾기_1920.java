package backjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 개의 수
        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // 공백
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        // m 개의 수
        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;
            boolean hasNum = false;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arrM[i] == arrN[mid]) {
                    hasNum = true;
                    break;
                } else if (arrM[i] < arrN[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            if (hasNum) arrM[i] = 1;
            else arrM[i] = 0;
        }
        for (int i : arrM) {
            System.out.print(i+" ");
        }


    }
}
