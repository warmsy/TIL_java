package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = new int[3];
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                len[i] = Integer.parseInt(st.nextToken());
            }
            if (len[0] == 0 && len[1] == 0 && len[2] == 0 ) break;

            Arrays.sort(len);
            if (Math.pow(len[2], 2) == Math.pow(len[0], 2) + Math.pow(len[1], 2)) {
                System.out.println("right");
            } else System.out.println("wrong");}
    }
}
