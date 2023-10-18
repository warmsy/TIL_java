package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [] dp = new int[size+1];
        int [] arr = new int[size+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=size; i++){
            arr [i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;

        // dp 테이블 작성하기
        for (int i=2; i<=size; i++){
            dp[i] = 1;  // 자기 자신부터 세어주기 위함.
            for (int j=1; j<i; j++){
                if (arr[j]>arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int longest = 0;
        for (int num : dp){
            longest = Math.max(longest, num);
        }

        System.out.println(longest);



    }
}
