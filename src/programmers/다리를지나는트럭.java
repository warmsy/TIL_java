package programmers;

import java.util.*;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println("answer  " + solution(bridge_length, weight, truck_weights));
        List<Integer> list = new ArrayList<>();
        int [] temp = list.stream().mapToInt(i->i).toArray();

        List<String> list2 = new ArrayList<>();
        String [] temp2 = list2.toArray(new String[list2.size()]);

        int [] temp3 = list.stream().mapToInt(i->i).toArray();
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sumTruckWeight = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    sumTruckWeight += truck;
                    answer++;
                    break;
                } else {
                    if (queue.size() == bridge_length) {
                        sumTruckWeight -= queue.poll();
                    } else if (sumTruckWeight + truck > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(truck);
                        sumTruckWeight += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}

