package programmers.해쉬;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String [] genres = {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = {500, 600, 150, 800, 2500};
        String first, second;
        // 1.for 돌면서 map에 값 넣는데 장르를 키로 넣고 String으로 값 축적
        Map <String, Integer> map = new HashMap<>();

        for (int i=0; i<genres.length; i++){
            if (map.containsKey(genres[i])){
                int sum = map.get(genres[i])+plays[i];
                map.put(genres[i], sum);
            }
            else {
                map.put(genres[i], plays[i]);
            }
        }
        // 여기까지 하면 가장 많이 재생된 장르를 구할 수 있음

        // 2. 값을 비교해서 제일 많이 재생된 장르 1,2 구하기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            entry.getValue()
        }

    }
}
