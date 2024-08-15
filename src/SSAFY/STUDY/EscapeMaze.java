package STUDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EscapeMaze {

    static int[] dx = {-1, 1, 0, 0}; // up, down
    static int[] dy = {0, 0, -1, 1}; // left, right

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M]; // 미로를 저장할 2차원 배열

        // 미로 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j)-'0'; // 문자 '0' 또는 '1'을 숫자로 변환하여 저장
            }
        }

        System.out.println(Arrays.deepToString(maze)); // 잘 들어갔나

        // BFS를 이용해 최소 이동 칸의 개수를 구하기
        int result = bfs(maze, N, M);
        System.out.println(result); // 결과 출력
    }

    // BFS 함수 정의
    public static int bfs(int[][] maze, int N, int M) {
        // 큐를 생성하여 BFS를 시작
        ArrayDeque <int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0}); // 시작 위치를 큐에 추가

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치를 꺼냄
            int x = current[0];
            int y = current[1];

            // 현재 위치에서 네 방향으로 이동 가능한지 체크
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로를 벗어나지 않도록 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 괴물이 있는 부분(0) 이거나 이미 방문한 칸이면 건너뜀
                if (maze[nx][ny] == 0) continue;

                // 처음 방문하는 칸에 대해 이전 칸까지의 이동 수 + 1을 기록
                if (maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        // 출구(N-1, M-1)까지의 이동 칸 수 반환
        return maze[N-1][M-1];
    }
}

