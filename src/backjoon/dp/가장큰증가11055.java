package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [] dp = new int[size+1];
        int [] arr = new int[size+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];     // 시작 부분은 이전까지 더한 값이 없기 때문에.

        // 가장 크게 증가하는 부분 수열의 누적합 중 최대가 되는 값을 알기 위함.
        for (int i=2; i<=size; i++){
            dp[i] = arr[i]; // 자신의 값을 DP 에 저장.
            for (int j=1; j<i; j++){
                if (arr[i] > arr[j]){   // 기준값이 더 클 때
//                    dp[i] = Math.max(dp[i], dp[i]+arr[j]);  // 부분증가 수열이므로 DP 갱신
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]); // 기준값의 dp 값과 누적합의 크기 비교.
                }
            }
        }
        int max = 0;
        for (int num : dp){
            max = Math.max(max, num);
        }
        System.out.println(max);



    }
}
