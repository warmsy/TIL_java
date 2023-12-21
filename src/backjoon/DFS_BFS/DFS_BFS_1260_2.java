package backjoon.DFS_BFS;

import java.util.*;

public class DFS_BFS_1260_2 {
    static boolean[] visited;    // 기본값 false 로 고정
    static ArrayList<Integer> [] graph;  // 각 노드의 연결 여부를 표시한 그래프

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node_num = sc.nextInt();    // 노드의 개수
        int line_num = sc.nextInt();    // 간선의 개수
        int start_num = sc.nextInt();   // 탐색 시작 노드
        visited = new boolean[node_num + 1];
        graph = new ArrayList[node_num + 1];

        for (int i = 1; i <= node_num; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // graph 값 세팅
        for (int i = 0; i < line_num; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        // 그래프 안의 수를 크기순 정렬
        for (int i = 1; i <= node_num; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start_num);
        System.out.println();
        Arrays.fill(visited, false);    // 안에 값을 전부 false 로 변경
        bfs(start_num);
    }

    private static void dfs(int start_num) {
        // 1. 방문처리
        visited[start_num] = true;
        System.out.print(start_num+" ");
        // 2. 순회돌며 확인하기
        for (int node : graph[start_num]) {
            // 3. 미방문시 재귀호출
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    private static void bfs(int start_num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_num);
        visited[start_num] = true;

        while (!queue.isEmpty()) {
            int start_node = queue.poll();
            System.out.print(start_node+ " ");

            for (int node : graph[start_node]) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

    }


}



