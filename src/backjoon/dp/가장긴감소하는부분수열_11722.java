package backjoon.dp;

import java.util.*;
import java.io.*;

public class 가장긴감소하는부분수열_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int [] arr = new int[length+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [] dp = new int[length+1];
        dp[0] = 1;

        for (int i=1; i<= length; i++){
            if (arr[i-1] <=arr[i]){
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = dp[i-1] +1;
            }
        }
//        for (int i : dp){
//            System.out.println("dp "+i);
//        }
        int max = 0;
        for (int i=0; i<=length; i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

    }
}
