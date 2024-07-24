package backjoon.DFS_BFS;

import java.util.Scanner;

public class 섬의개수_4963 {

    static int [][] arr;
    static boolean [][] visited;
    static int r;
    static int c;
    static int [] dx = {-1, 1, 0, 0, -1, 1,1,-1};
    static int [] dy = {0, 0, -1, 1, 1, 1,-1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            r = sc.nextInt();
            c = sc.nextInt();

            if (r==0 && c==0) break;

            arr = new int[r][c];
            visited = new boolean[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int cnt =0;

            for(int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    if (arr[i][j]==1 && !visited[i][j]){
                        dfs(i, j);
                        cnt ++;
                    }
                }
            }
            System.out.println();

        }
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<8; i++) {
            int cx = x+dx[i];
            int cy = y+dy[i];

            if(cx>=0 && cy>=0 && cx<r && cy <c) {
                if (arr[cx][cy]==1 && !visited[cx][cy]) {
                    dfs(cx, cy);
                }
            }

        }
    }
}
