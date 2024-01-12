package programmers.스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리지나는트럭 {
    public static void main(String[] args) {
        int bridgeLength = 2; //100;
        int weight = 10; // 100;
        int[] truckWeights = {7, 4, 5, 6}; // {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridgeLength, weight, truckWeights));

    }

    static int solution(int bridgeLength, int weight, int[] truckWeights){
        int answer = 0;
        int totalWeight =0;
        Queue<Integer> queue = new LinkedList<>();

        for (int truck : truckWeights) {
            while (true) {
                // queue 가 비어있을 때
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                }
                // queue 가 비어있지 않을 떄
                else {
                    if (queue.size() == bridgeLength) {
                        totalWeight -= queue.poll();
                    } else if (totalWeight + truck > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(truck);
                        totalWeight += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridgeLength;
    }

}
