
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class 미로1 {
    private static int[][] map= new int[16][16];    // 고정값이라 딱히 상관없을듯
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0,-1, 1};
    private static int answer;
    private static boolean [][] visited; // 너도

    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("./src/res/input_1226.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] start = new int[2];
        int[] end = new int[2];

        for (int tc = 1; tc < 11; tc++) {
            sb.append("#").append(tc).append(" ");
            int test_case = Integer.parseInt(br.readLine());
            // map 초기화하기
            for (int i = 0; i < map.length; i++) {
                char [] line = br.readLine().toCharArray();
                for (int j = 0; j <line.length; j++) {
                    int c = line[j]-'0';
                    if (c == 2) {
                        start[0] = i;
                        start[1] = j;
                    } else if (c == 3) {
                        end[0] = i;
                        end[1] = j;
                    }
                    map[i][j] = c;
                }
            }
//            System.out.println(Arrays.deepToString(map));
            answer = 0;
            visited = new boolean[16][16];
            bfs(start, end);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(int[] start, int[] end){
        ArrayDeque<int []> queue = new ArrayDeque<>();
        visited [start[0]][start[1]] = true;    // 방문처리
        queue.offer(start); // 처음 값 넣어주기, int 배열
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            // 사방 탐색 시작
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + point[0];
                int ny = dy[d] + point[1];
                // 범위를 넘어가거나
                if (nx<0 || ny<0 || nx>=16 || ny>=16) continue;
                // 벽을 만났거나, 방문한 곳이거나
                if (map[nx][ny] == 1 || visited[nx][ny]) continue;
                // 하면 다 제끼고 만약 도착지 만나면?
                if (map[nx][ny] == 3) {
                    answer = 1;
                    return; // 끝내주고
                }

                // 제낀다음에 제대로 들어왔으며는 queue에 넣어주고
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

}
