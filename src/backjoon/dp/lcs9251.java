package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lcs9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = " " + br.readLine();
        String second = " " + br.readLine();
        char[] shortArray, longArray;
        if (first.length() < second.length()) {
            shortArray = first.toCharArray();
            longArray = second.toCharArray();
        } else {
            shortArray = second.toCharArray();
            longArray = first.toCharArray();
        }

        int[] dp = new int[shortArray.length];
        for (int i = 1; i < shortArray.length; i++) {
            for (int j = i; j < longArray.length; j++) {
                if (shortArray[i] == longArray[j]) {
                    dp[i] = dp[i - 1] + 1;
                    break;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        Arrays.sort(dp);
        int max = dp[dp.length - 1];
        System.out.println(max);

    }
}
