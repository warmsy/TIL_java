package programmers;

import java.io.LineNumberReader;
import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        // 더 나은 풀이
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Set<String> set = new HashSet<>();
        String[] arr = s.replace("{", " ").replace("}", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        for (int a : answer) {
            System.out.println(a);
        }


        // 대박적.. 이케 하면 하나의 튜플까지도 다 쪼개져서 나온다 어캄 ㅠ
        // 틀린 풀이
//        s = s.substring(1, s.length() - 2);
//        s = s.replace("{", "");
////        System.out.println(s);
//        String[] arr = s.split("},");
//        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
//        s = String.join("", arr);
//        s = s.replace(",", "");
//        System.out.println(s);
//
//        char[] arr2 = s.toCharArray();
////        for (int i=0;  i<s.length(); i++){
////            arr2[i] = Integer.parseInt(arr[i]);
////        }
//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        for (char num : arr2) {
//            set.add(Integer.parseInt(String.valueOf(num)));
//        }
//        System.out.println(set.toString());
//
//        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();

        // 고친 풀이
//        // 1. s를 배열로 만들어주기
//        s = s.substring(1, s.length() - 2);
//        s = s.replace("{", "");
//        String[] arr = s.split("},");
//        // 2. 문자열 길이에 따라 정렬
//        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
//        s = String.join(",", arr);
//        arr = s.split(",");
//        // 3. 중복 제거
//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        for (String num : arr) {
//            set.add(Integer.parseInt(num));
//        }
//        // 4. set -> int [] 변환
//        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
//        for (int a : answer) {
//            System.out.println(a);
//        }


    }
//

}

