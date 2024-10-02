package SSAFY.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013 {
    private static int[][] gears = new int[5][8]; // 톱니바퀴 상태를 저장하는 배열 (1~4번 톱니바퀴 사용)
    private static int K; // 회전 횟수
    private static int[] rotations; // 회전 방향을 저장해줄 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(br.readLine());

            // 톱니바퀴 초기화
            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전 명령 처리
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int gearIdx = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
                int direction = Integer.parseInt(st.nextToken()); // 시계 1, 반시계 -1

                // 회전 방향 저장 배열 초기화
                rotations = new int[5];
                rotations[gearIdx] = direction;

                // 좌우 연쇄 회전 여부 결정
                toRight(gearIdx + 1, direction * (-1));
                toLeft(gearIdx - 1, direction * (-1));

                // 모든 톱니바퀴 회전
                rotateAll();
            }

            // 점수 계산
            int total = 0;
            if (gears[1][0] == 1) total += 1;
            if (gears[2][0] == 1) total += 2;
            if (gears[3][0] == 1) total += 4;
            if (gears[4][0] == 1) total += 8;

            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }

        System.out.println(sb);
    }

    // 오른쪽 톱니바퀴 연쇄 회전 결정
    private static void toRight(int gearIdx, int direction) {
        if (gearIdx > 4) return;
        if (gears[gearIdx - 1][2] != gears[gearIdx][6]) { // 인접한 톱니바퀴들이 다른 극이면
            rotations[gearIdx] = direction;
            toRight(gearIdx + 1, direction * (-1)); // 다음 톱니바퀴를 반대 방향으로 회전시킬지 결정
        }
    }

    // 왼쪽 톱니바퀴 연쇄 회전 결정
    private static void toLeft(int gearIdx, int direction) {
        if (gearIdx < 1) return;
        if (gears[gearIdx][6] != gears[gearIdx - 1][2]) { // 인접한 톱니바퀴들이 다른 극이면
            rotations[gearIdx] = direction;
            toLeft(gearIdx - 1, direction * (-1)); // 다음 톱니바퀴를 반대 방향으로 회전시킬지 결정
        }
    }

    // 모든 톱니바퀴 회전
    private static void rotateAll() {
        for (int i = 1; i <= 4; i++) {
            if (rotations[i] != 0) {
                rotate(i, rotations[i]);
            }
        }
    }

    // 회전 처리
    private static void rotate(int idx, int direction) {
        if (direction == 1) { // 시계방향 회전
            int tmp = gears[idx][7];
            for (int i = 7; i > 0; i--) {
                gears[idx][i] = gears[idx][i - 1];
            }
            gears[idx][0] = tmp;
        } else { // 반시계방향 회전
            int tmp = gears[idx][0];
            for (int i = 0; i < 7; i++) {
                gears[idx][i] = gears[idx][i + 1];
            }
            gears[idx][7] = tmp;
        }
    }
}
