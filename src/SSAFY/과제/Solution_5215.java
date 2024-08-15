package 과제;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215 {
    static int menu, maxCal; // 초기값
    static int [][] ev;
    static int maxScore;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./res/input_5215.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            maxScore = 0;
            st = new StringTokenizer(br.readLine());
            menu = Integer.parseInt(st.nextToken());    // 메뉴 개수
            maxCal = Integer.parseInt(st.nextToken());  // 칼로리
            ev = new int[menu][2]; // 점수, 칼로리
            for (int i = 0; i < menu; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    ev[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combination(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(maxScore).append("\n");

        }
        System.out.println(sb);
    }
    private static void combination(int idx, int score, int cal){
        if (cal> maxCal) { // 이하니까 범위는 초과로 설정

            return;
        }
        maxScore = Math.max(maxScore, score);

        for (int i = idx; i < menu; i++) { // N 재료의 개수
            combination(i + 1, score + ev[i][0], cal + ev[i][1]);
        }
    }
}
