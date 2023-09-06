package backjoon;

import java.util.*;
// count 처리 관련해서 다른 사람 풀이 참고하기
// sc.nextLine(); 부분 설명 다시보기

public class 단지번호붙이기 {
    static int n;
    static int[][] arr;
    static int count =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();  // 이거 왜 쓰는지 모르겠음
        // 버퍼 지우기 -> nextInt()이후에 있던 띄어쓰기 값 제거해줌.
        arr = new int[n][n];
        ArrayList<Integer> answer = new ArrayList<>();
        // 한 줄로 받아온 단지의 지도를 배열에 넣어줌.
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';    // ascii code 0을 빼줘서 정수형으로 변환
            }
        }
        // dfs 알고리즘 호출, 모든 위치를 다 돌기.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if 문에서 false 가 나오기 때문임.
                if (dfs(i, j)) {
                    answer.add(count);
                    count =0;
                }
            }
        }
        Collections.sort(answer);
        System.out.println("answer  " + answer.size());
        for (int i : answer) {
            System.out.println(i);
        }
    }

    // dfs 는 다 돌아. 근데 answer 에 들어가는 값이 하나도 없어.
    static boolean dfs(int x, int y) {
        // 조건 붙여주기
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        // 방문여부 확인
        if (arr[x][y] == 1) {   // 방문 하지 않았으면
            arr[x][y] = 0;  // 좌표의 값을 0으로 만들어 방문처리
            count++;    // 방문 처리 후 카운트

            dfs(x - 1, y);   // 상
            dfs(x + 1, y);   // 하
            dfs(x, y - 1);   // 좌
            dfs(x, y + 1);   // 우
            return true;
        }
        return false;
    }
}
