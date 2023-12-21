package backjoon.DFS_BFS;

import java.util.*;

public class DFS_BFS_1260 {
    static boolean[] visited;    // 기본값 false 로 고정
    static int[][] graph;  // 각 노드의 연결 여부를 표시한 그래프

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node_num = sc.nextInt();    // 노드의 개수
        int line_num = sc.nextInt();    // 간선의 개수
        int start_num = sc.nextInt();   // 탐색 시작 노드
        graph = new int[node_num + 1][node_num + 1];
        visited = new boolean[node_num + 1];

        // 각 노드에 연결 여부
        for (int i = 0; i < line_num; i++) {
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            graph[index1][index2] = 1;
            graph[index2][index1] = 1;
        }
        dfs(start_num);
        System.out.println();
        Arrays.fill(visited, false);    // 안에 값을 전부 false 로 변경
        bfs(start_num);
    }

    private static void dfs(int start_num) {

    }

    private static void bfs(int start_num) {
    }


//    private static void dfs(int start_num) {
//        visited[start_num] = true; // 노드 방문 처리
//        System.out.print(start_num + " ");
//        // 해당 노드의 연결여부와 방문 여부 확인
//        for (int i = 1; i < graph[start_num].length; i++) {
//            if (graph[start_num][i] == 1 && !visited[i]) {  // 기준 노드와 연결되어 있지만 탐색 X이면
//                dfs(i);
//            }
//        }
//    }
//
//    private static void bfs(int start_node) {
//        Queue<Integer> que = new LinkedList<>();
//        que.offer(start_node);
//        visited[start_node] = true;
//
//        while (!que.isEmpty()) {    // 큐가 빌 때까지 반복
//            start_node = que.poll(); // 큐의 값 제거, 기준 노드 설정
//            System.out.print(start_node + " ");
//            for (int i = 1; i < graph[start_node].length; i++) {
//                if (graph[start_node][i] == 1 && !visited[i]) {
//                    que.offer(i);
//                    visited[i] = true;
//                }
//            }
//        }
//    }
}



