package programmers.해쉬;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        int answer = Solution(clothes);
        System.out.println(answer);
    }

    static int Solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        // 1. 리스트 순회하면서 key (옷의종류), value (개수) 구하기
        // 2. 이미 존재하면 .contains > value+ 해주기
        // 3. key 의 개수만큼 경우의 수 구해주기
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer-1;
    }
}


//    public static void main(String[] args) {
//        String[][] clothes = {{"yellow_hat", "headgear"},
//                {"blue_sunglasses", "eyewear"},
//                {"green_turban", "headgear"}};
//        int answer = Solution(clothes);
//        System.out.println(answer);
//    }
//
//    static int Solution(String[][] clothes) {
//        int answer = 0;
//        Map<String, Integer> map = new HashMap<>();
//        // 1. 리스트 순회하면서 key (옷의종류), value (개수) 구하기
//        // 2. 이미 존재하면 .contains > value+ 해주기
//        // 3. key 의 개수만큼 경우의 수 구해주기
//
//
//        return answer;
//    }
//
//    // 조합 구하는 함수
//    static int Combination(int n, int m) {
//        int answer = Factorial(n) / (Factorial(n - m) * Factorial(m));
//        return answer;
//    }
//
//    static int Factorial(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        int fac = 1;
//        for (int i = 1; i <= n; i++) {
//            fac = fac*i;
//        }
//        return fac;
//    }