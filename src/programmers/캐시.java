package programmers;

import java.util.ArrayList;

public class 캐시 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        ArrayList<String> list = new ArrayList<>();
        int answer = 0;

        if (cacheSize != 0) {   // cacheSize 체크
            for (int i = 0; i < cities.length; i++) {
                // 대소문자 구분 X
                cities[i] = cities[i].toLowerCase();
                // cities 포함 여부 확인
                if(list.contains(cities[i])){
                    answer += 1;
                    list.remove(cities[i]);
                    list.add(cities[i]);
                }
                else {
                    answer += 5;
                    if(list.size()<cacheSize) list.add(cities[i]);
                    else {
                        list.remove(0);
                        list.add(cities[i]);
                    }
                }
            }
        } else {
            answer = 5 * (cities.length);
        }

        System.out.println(list.toString());

        System.out.println(answer);
    }
}
//        Queue<String> queue = new LinkedList<>();
//        for (int i=0; i<cities.length; i++){
//            if (queue.size()<cacheSize){
//                queue.offer(cities[i]);
//                answer += 5;
//            }
//            else {
//                if(queue.poll().equals(cities[i])){
//                    answer += 1;
//                    queue.offer(cities[i]);
//                }
//                else {
//                    answer+=5;
//                    queue.offer(cities[i]);
//                }
//            }
//        }
