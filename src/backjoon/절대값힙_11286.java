package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_11286 {
    public static void main(String[] args) throws IOException {
        // 우선순위 큐 & 우선순위 정렬 기준 커스텀
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    // 들어오는 데이터가 많을 경우, scanner보다 시간복잡도 면에서 유리함
        int N = Integer.parseInt(br.readLine());
        // 우선순위 큐 정의
//        PriorityQueue<Integer> myQueue = new PriorityQueue<>(); 보통은 이렇게 끝인데 우선순위 정렬기준 커스텀이 필요함.
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {    // 이부분이 이해가 안된다. 우선순위큐의 우선순위 지정해주는 방법과 우선순위 큐가 뭔지.. 개념도 좀 알아야되겠다.
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {    // 절대값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs;  // 절대값이 작은 데이터 우선
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                if (q.isEmpty()){
                    System.out.println("0");
                }else {
                    System.out.println(q.poll());
                }
            }else {
                q.offer(num);
            }


        }
    }
}
