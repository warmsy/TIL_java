package programmers.DFSBFS;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class 최단거리 {

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int [][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int [][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};


        System.out.println(solution(maps1));

    }

    static int solution(int[][] maps) {
        // 1. 기본 요소 정의(맵, 방문여부, 상하좌우)
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        // bfs 에 값 넣어주기
        if (maps[n - 2][m - 1]==0 && maps[n-1][m-2] == 0) {
             return -1;
        }
        else {
            bfs(maps);
            return maps[n - 1][m - 1];
        }
    }

    static void bfs(int [][] maps) {
        // 1. 방문여부 체크
        int x = 0;
        int y = 0;
        int n = maps.length;
        int m = maps[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        // while 돌면서 전체 체크해주기
        while (!queue.isEmpty()) {
            // point 에 큐에 있는 값 뺴서 담아주기
            Point currentPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                // 1. 범위 내?
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                // 2. 막힌 길?
                if (maps[nextX][nextY] == 0) {
                    continue;
                }
                // 3. 방문여부
                if (visited[nextX][nextY]) continue;

                // 해당없음(=갈 수 있는 길)
                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;

                maps[nextX][nextY] = maps[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}
