package STUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 얼음얼려먹기 {
    private static int N, M;
    private static int[][] map = new int[1000][1000]; // 최대크기 선언

    private static boolean dfs(int x, int y) {
        // 주어진 좌표가 범위 내에 있는지 확인
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false; // 범위를 벗어나면 false
        }
        // 현위치에 얼음이 있다면
        if (map[x][y] == 0) {
            // 현위치를 방문 처리
            map[x][y] = 1;

            dfs(x - 1, y); // 상
            dfs(x + 1, y); // 하
            dfs(x, y - 1); // 좌
            dfs(x, y + 1); // 우

            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //각각 행과 열의 크기로 설정
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 얼음틀의 초기 상태를 입력받아 map 배열에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0; // 얼음 덩어리 개수를 저장할 변수

        // 모든 위치를 순회, 아이스크림 개수 계산ㄴ
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 현재 위치 dfs
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}