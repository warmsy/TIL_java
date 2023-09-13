package backjoon;

import java.util.*;

public class n과m_15649 {

    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int [] arr;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[n];

        dfs(n, m, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) { // 탈출 조건
            for (int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {    // dfs 루프
            if (!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visited[i] = false;
            }

        }


    }


}
