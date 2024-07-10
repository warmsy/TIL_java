package backjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 미세먼지안녕_17144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 기본 세팅
        // 격자 판
        int R = sc.nextInt();
        int C = sc.nextInt();

        // 소요 시간 T초
        int T = sc.nextInt();

        // 2차원 배열로 정보 받아오기
        // for문, C -> R , 값 받아오기
        int[][] arr = new int[R][C];

        // 공청기 위치 : 위쪽 아래쪽
        // 기존 코드 개선 -> 특정 값 비교했다가 조건 맞으면 값 바꾸기
        int upper = -1, lower = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == -1) {
                    if (upper == -1) upper = i;
                    else lower = i;
                }
            }
        }

        // 방향성 표시하기 위한 코드 좌우상하
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 1) 전체 T번 반복
//        for (int t = 0; t < T; t++) {}
            // 값 오류 대비해서 temp 배열
            int[][] temp = new int[R][C];
            // 2) 확산 되는 경우 구하기
            // 2-1)배열 안의 값이 0이면 continue, 0아니면 확산되는 양 구하기
            // 절대로!! 원본 배열 바로 바꾸지 말기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] > 0) {
                        // 2-2) i+dx, j+dy for문 돌려서 진행 가능 방향 구하고 진행 가능하면 확산 되는 양으로 arr[i+dx][j+dy] 값에
                        // 확산될 양 추가 & 카운트
                        int dust = arr[i][j] / 5;
                        int cnt = 0;

                        // 여긴 특히나 오타 조심할 것.
                        for (int d = 0; d < 4; d++) {
                            int idx = i + dx[d];
                            int idy = j + dy[d];
                            if (idx < R && idx >= 0 && idy < C && idy >= 0 && arr[idx][idy] != -1) {
                                temp[idx][idy] += dust;
                                cnt++;
                            }
                        }
                        temp[i][j] += arr[i][j] - (dust * cnt);
                    } else {
                        temp[i][j] += arr[i][j];
                    }
                }
            }
            arr = temp;

        System.out.println(Arrays.deepToString(arr));

        // 3) 공기 청정 바람 부는 경우 구하기
        // 공기 청정 바람이 부는 방향을 구하려면? -> 공기 청정의 위치 알아둬야 함.
        // 1초당 확산 -> 청정 ( 청정과 만나면 값이 0이 됨) 코드에서 -1d의 위치를 판별해 줘야함.
        // 4방향 기본, 가운데 남은 값은 방향이 정해지면 구함
        // 3-1) 위쪽 (반시계)
        for (int i=0; i<C-1; i++) {
            arr[0][i] = arr[0][i+1];
        }
        for (int i = upper - 1; i > 0; i--) {
//            arr[i][0]
        }


    }
}


