package programmers.카카오;

import java.util.*;

public class 개인정보 {
    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }


    static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 1. 오늘 날짜 정수 전환
        int now = dateChanger(today);
        // 2. terms 를 map 으로 전환
        HashMap<String, String> map =new HashMap<>();
        for (String s : terms){
            map.put(s.substring(0,1), s.substring(2));
        }
        // 3. 만료된 인덱스 번호 추출
        for (int i=0; i<privacies.length; i++) {
            String k = privacies[i].substring(privacies[i].length()-1);
            if (map.containsKey(k)){
                int validate = dateChanger(privacies[i]) + Integer.parseInt(map.get(k))*28;

                if (validate <= now) {
                    answer.add(i+1);
                    System.out.println(i+"본째"+validate);
                }

            }

        }

        int [] result = answer.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    // 날짜 변환 메소드
    static int dateChanger(String date) {
        return Integer.parseInt(date.substring(0, 4))*12*28 +
                Integer.parseInt(date.substring(5, 7))*28 +
                Integer.parseInt(date.substring(8, 10));
    }

}


