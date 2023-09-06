package backjoon;

import java.util.*;

public class DFS_BFS {

    public static ArrayList<Integer> [] graph ;
    public static boolean [] visited ;

    public static void main(String[] args) {
        // 1. 입력 값 받아주기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        // 2. 그래프와 방문여부 배열 만들기
        // dfs, bfs 에서도 쓰는데
        graph = new ArrayList[n+1]; // 인덱스 0을 제외하고 시작하기 떄문
        visited = new boolean[n+1]; // 초기화만 해두면 기본으로 false 값이 삽입 되어있음.

        // 2-1) graph 채우기 배열 안에 배열,
        for (int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        // 2-2) 배열 채우기
        for (int i=0; i<m; i++){
            int x = sc.nextInt(); // 입력받을 m의 첫번쨰 값.
            int y = sc.nextInt();   // 입력받은 m의 두번째 값.
            graph[x].add(y);
            graph[y].add(x);
        }

        // 2-3) 배열 정렬
        for (int i =1; i<=n; i++){
            Collections.sort(graph[i]); // 각 노드에 연결된 노드들을 오름차순으로 정렬.
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);    // dfs 수행 후 전부 true 로 바뀐 값 다시 false로 바꿔주기
        bfs(v);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v+" ");
        for (int node : graph[v]){
            if(!visited[node]){
                dfs(node);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v); // 시작값을 queue에 넣고
        visited[v] = true;  // 방문처리
        while (!queue.isEmpty()){
            int node = queue.poll();    // queue 에 들어간 값 빼서 확인하고
            System.out.print(node+" "); // 출력
            for (int i : graph[node]){  // 확인한 값의 인접 노드 확인하는데
                if (!visited[i]){   // 방문처리 안되어있으면
                    queue.offer(i); // 큐에 넣고
                    visited[i] = true;  // 방문 처리
                }
            }
        }

    }

}
