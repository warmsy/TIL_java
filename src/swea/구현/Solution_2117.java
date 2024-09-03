package swea.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2117 {
    static int N, M, totalHouse;
    static int[][] map;
    static ArrayList<int[]> houses;

    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("./src/res/input_2117.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            houses = new ArrayList<>();
            totalHouse = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) houses.add(new int[]{i, j});    // 집의 좌표 저장
                }
            }
            // 범위에서 k 가 N일 때 부터 돌아주기 -> 근데 범위 계산하고 이득이 더 커야됨.
            int diamond = N;
            if (N % 2 == 0) {
                diamond ++;
            }
            for (int k = diamond; k > 0; k--) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        findHouse(k, i, j); // 집의 최대 개수 찾아주기 위한
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(totalHouse).append("\n");
        }
        System.out.println(sb);
    }

    // 마름모 내부에 집이 들어오는지 보기 위한 함수
    // k 마름모 사이즈, x,y 마름모의 중앙 좌표
    static void findHouse(int k, int x, int y) {
        int manDistance;
        int cntHouse = 0, profit;
        for (int[] point : houses) {
            // 맨하탄 디스턴스 구해주기
            manDistance = Math.abs(point[0] - x) + Math.abs(point[1] - y);
            // 집이 맨하탄 범위 내에 있는지? 있으면 cnt
            if (manDistance < k) {
                cntHouse++;
            }
        }
        // 집이랑 확인해서 전부 다 돌았으면
        // 이득 따져보기
        profit = cntHouse * M - (k * k + (k - 1) * (k - 1));
        if (profit >= 0) totalHouse = Math.max(totalHouse, cntHouse);
        // 이득이면? 최대 집 개수로 갱신
        // total 갱신해준거 더 안되면 break 해줘도 될거같은데
    }
}
