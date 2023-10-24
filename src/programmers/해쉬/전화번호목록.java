package programmers.해쉬;

import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        boolean result = Solution(phone_book);
        System.out.println(result);

    }

    public static boolean Solution(String[] phone_book) {
        HashMap<String, String> map = new HashMap<>();
        // 길이가 가장 짧은 순으로 정렬
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        // 가장 짧은 번호의 길이
        int len = phone_book[0].length();
        // 배열을 돌며 가장 짧은 길이대로 잘라줌.
        for (String num : phone_book) {
            String key = num.substring(0, len);
            if (map.containsKey(key)) {
                String value = map.get(key);    // key값에 해당하는 value를 불러옴.
                if (num.startsWith(value)) {    // key가 이미 존재하면, value 가 접두사가 되는지 한번 더 확인해줌.
                    // 접두사가 되려면 어떤 전번의 전체 길이가 다른 수의 접두사인지 확인해주면 됨.
                    return false;
                }
            }
            map.put(key, num);
        }
        return true;
    }
}
