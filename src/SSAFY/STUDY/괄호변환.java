package STUDY;

public class 괄호변환 {
    public static void main(String[] args) {

        String input = "()))((()";

        Solution s = new Solution();

        System.out.println(s.solution(input));
    }


    static class Solution {
        public String solution(String str) {
            // 1. 빈 문자열이면 뱉기
            if (str.isEmpty()) return "";

            // 2. 문자열을 u, v로 분리
            int open = 0, closed = 0;
            int i;
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') open++;
                else closed++;
               /// 균형이 맞으면?
                if (open == closed) break;
            }

            String u = str.substring(0, i + 1);// 처음봣을때문자열
            String v = str.substring(i + 1); // 나머지 문자열

            // 괄호 똑바로?
            if (isCorrect(u)) {
                // 바르면 결과 뱉
                return u + solution(v);
            } else {
                // 애매하면 다시 생성
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(solution(v)); // 재귀호출
                sb.append(")");
                sb.append(reverse(u.substring(1, u.length() - 1))); // 뒤집기
                return sb.toString();// 이땐 스트링 처리
            }
        }

        // u가 올바른 괄호 문자열인지 확인하는 함수
        private boolean isCorrect(String u) {
            int count = 0;
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') count++;
                else count--;
                // 올바르지 않다면 false 반환
                if (count < 0) return false;
            }
            return count == 0;
        }

        // 문자열의 괄호 방향을 뒤집는 함수
        private String reverse(String u) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
            return sb.toString();
        }
    }

}
