package swea.MTS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1251 {

    static int N;
    static int[] parents;

    static void make() {
        parents = new int[N];   // 부모 배열을 만들어주고
        Arrays.fill(parents, -1);// -1로 초기화
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);// 부모 찾아서 변경(=path compression)
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a); // 부모가 같은지 판별을 위함
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;   // 부모가 같으면? 안되고
        parents[aRoot] += parents[bRoot];   // 아니면 합치고
        parents[bRoot] = aRoot; // compression 일수도 있고 아닐수도 있는거 수행
        return true;
    }


    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("./src/res/input_1251.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());    // 섬의 개수
            int[] x = new int[N];
            int[] y = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            // ave rates
            double E = Double.parseDouble(br.readLine());

            // 좌표를 담아줄 배열 생성 및 초기화
            int[][] xy = new int[N][2];
            for (int i = 0; i < N; i++) {
                xy[i][0] = x[i];
                xy[i][1] = y[i];
            }
            // 좌표들과 가중치를 담을 클래스를 담아줄 배열 생성인데
            // arraylist로 할지 멀지 아직 애매하지만 아마 빠짐없이 최소거리로 넣는다면  v-1개로 추정중.
            // 근데 아직 최소거리로 간선 넣는것도 안구했고, 경우의 수 조합은 nC2 아잉교 그니까 걍 .. ArrayList로 넣는게 신상에 이로울 듯
            ArrayList<Route> routes = new ArrayList<>();

            // 좌표 조합을 통한 가중치 구하기
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    double d = Math.sqrt(Math.pow(Math.abs(xy[i][0] - xy[j][0]), 2) + Math.pow(Math.abs(xy[i][1] - xy[j][1]), 2)); // 두 정점의 사이 가중치
                    Route route = new Route(i, j, d);
                    routes.add(route);
                }
            }
            Collections.sort(routes);   // Collection 애들은 Collections 로 잊지말기
            // Good 여기까진 예상대로 동작

            // 와 시작
            make();
            int cnt = 0;
            double cost = 0;
            for (Route route : routes) {
                if (union(route.v1, route.v2)) {
                    cost += Math.pow(route.weight, 2);
                    if (++cnt == N - 1) break;    // mst 완성
                }
            }
            double total = cost * E;   // 교훈 : 아다르고 어 다르다 쟤는 어일수도 있으니까 한번 더 생각해보는 미덕을 갖ㄱ추자.
            sb.append("#").append(tc).append(" ").append(Math.round(total)).append("\n");
            // 테케 반타작 실화? ㅠ 이럴떈 디버깅우째야댐 환장하것네
            // 는 ^^ 제가 cost를 ^^ int로 처리했기 떄문이져? 업보빔 ~ ^q^bb 냠긋~
        }
        // 오늘의 교훈 : 수가 거대해 질 떄 자료형을 잘 보자 ^~^!
        System.out.println(sb);
    }

    static class Route implements Comparable<Route> {
        int v1, v2; // 정점의 idx 번호
        double weight; // 두 정점 사이 가중치

        public Route(int v1, int v2, double weight) {
            super();
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Route o) {
            return Double.compare(this.weight, o.weight);   // double 값 중 머가 더 큰지 비교
        }
    }
}
