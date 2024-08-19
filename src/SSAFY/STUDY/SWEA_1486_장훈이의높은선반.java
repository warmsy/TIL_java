package STUDY;

import java.util.*;
import java.io.*;

public class SWEA_1486_장훈이의높은선반 {
    static int N, B, minSub;
    static int[] person;
    static boolean[] visited;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            person = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                person[n] = Integer.parseInt(st.nextToken());
            }

            minSub = Integer.MAX_VALUE;
            // 부분 집합
            subSet(0);
            sb.append("#").append(tc).append(" ").append(minSub).append("\n");
        }
        System.out.println(sb);
    }

    private static void subSet(int cnt) {
        // 기저 조건
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += person[i];
                }
            }
            if (sum >= B) {
                int diff = sum - B;
                minSub = Math.min(diff, minSub);
            }
            return;
        }

        visited[cnt] = true;
        subSet(cnt + 1);
        visited[cnt] = false;
        subSet(cnt + 1);
    }
}
