package programmers.스택큐;

import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 3,7,9,2, 1};
        int location = 4;

        System.out.println(Solution(priorities, location));

    }

//    static int Solution(int[] priorities, int location) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 내림차순 정렬
//        int answer =0;
//        for (int priority : priorities) {
//            pq.offer(priority); // 값을 삽입하면 내림차순으로 정렬됨. 시간복잡도 (logN)
//        }
//        while (!pq.isEmpty()) {
//            for (int i = 0; i < priorities.length; i++) {
//                // pq.peek() : 현재 가장 높은 우선순위
//                if (priorities[i] == pq.peek()) {
//                    if (i==location){ // 가장 높은 우선순위가 location 에 해당하면
//                        return ++ answer;
//                    }
//                    pq.poll();
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }
    static int Solution(int[] priorities, int location) {
        Queue<Integer> locations = new LinkedList<>();
        Queue<Integer> priorityQue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            locations.add(i);
            priorityQue.add(priorities[i]);
        }
        // priorities 배열에서 가장 큰 값 찾아주기
//        int max = Arrays.stream(priorities).max().getAsInt();
        int cnt = 0;
        Integer[] tmp = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        int max = tmp[cnt];
        // 이거 시간복잡도가 얼마나되지?

        while (true) {
            // 1. 우선순위에서 꺼낸 값이 max값과 같나?
            if (priorityQue.peek() == max) {
                // 같으면 값 꺼내고 버리고 카운트 ++
                priorityQue.poll();
                cnt++;
                if (locations.peek() == location) {  // 로케큐의 값과 로케의 값이 같냐?
                    return cnt; // 같으면 카운트 리턴
                } else {
                    locations.add(locations.poll()); // 다르면 로케 빼서 뒤로 보내기
                }
                max = tmp[cnt];
            } else {
                priorityQue.add(priorityQue.poll());
                locations.add(locations.poll());
            }
            // 다르면 뒤로 보내고 로케도 뒤로 보내기
        }
    }


}


//    Queue<Integer> locations = new LinkedList<>();
//    Queue<Integer> priorityQue = new LinkedList<>();
//        for (int i = 0; i < priorities.length; i++) {
//        locations.add(i);
//        priorityQue.add(priorities[i]);
//        }
//        // priorities 배열에서 가장 큰 값 찾아주기
////        int max = Arrays.stream(priorities).max().getAsInt();
//        int cnt = 0;
//        Integer[] tmp = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
//        Arrays.sort(tmp, Collections.reverseOrder());
//        int max = tmp[cnt];
//        // 이거 시간복잡도가 얼마나되지?
//
//        while (true) {
//        // 1. 우선순위에서 꺼낸 값이 max값과 같나?
//        if (priorityQue.peek() == max) {
//        // 같으면 값 꺼내고 버리고 카운트 ++
//        priorityQue.poll();
//        cnt++;
//        if (locations.peek() == location) {  // 로케큐의 값과 로케의 값이 같냐?
//        return cnt; // 같으면 카운트 리턴
//        } else {
//        locations.add(locations.poll()); // 다르면 로케 빼서 뒤로 보내기
//        }
//        max = tmp[cnt];
//        }
//        else {
//        priorityQue.add(priorityQue.poll());
//        locations.add(locations.poll());
//        }
//        // 다르면 뒤로 보내고 로케도 뒤로 보내기
//        }

//        while (true) {
//                if (priorityQue.peek() == max && locations.peek() == location) {
//                return ++cnt;
//                } else {
//                priorityQue.add(priorityQue.poll());
//                cnt++;
//                locations.add(locations.poll());
//                max = priorities[priorities.length -cnt-1];
//                }
//                }