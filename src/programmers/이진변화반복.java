package programmers;

public class 이진변화반복 {
    public static void main(String[] args) {
        String s = "1111111"	;
        int len = s.length();
        int zeroCount = 0;
        int totalCount = 0;

        // 1. 문자열에서 0 제거하기 & 제거 할 때 제거 횟수 세기
        // 2. 문자열 길이 이진법으로 표기하고
        // 3. 다시 문자열로 만들기 & 횟수 세기
        // 4. 이진법 표기에 1만 남으면 카운트와 총 횟수를 배열에 담아주기
        // System.out.print();

        while (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }
            s = s.replace("0", "");
            System.out.println(s);
            len = s.length();
            s = Integer.toBinaryString(len);
            System.out.println("s 이진변환" + s);
            totalCount++;
        }
        System.out.println(zeroCount);
        System.out.println(totalCount);
    }

}
