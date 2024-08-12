package STUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열압축 {
    public static void main(String[] args) throws Exception {
        // 풀이 ) 첫글자 부터 돌아가면서 같은거 찾아주자
        // 같은거 찾으면 카운트 하고
        // 최소길이를 구해보자 -> 여기가 어려웠다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        int answer = s.length();

        for (int i = 1; i < s.length() / 2; i++) {
            int pl = 1;
            String pStr = s.substring(0, i); // 압축하려는 문자를 0-1 까지 잘라줌

            for (int j = i; j < s.length(); j += i) { // i 압축할 문자열 길이만큼 j 증가
                String nextStr;
                if (j + i > s.length()) {
                    nextStr = s.substring(j, s.length());
                } else {
                    nextStr = s.substring(j, j + i);
                }
                if (pStr.equals(nextStr)) {
                    pl ++; // 같으면 압축 개수 +1
                } else {
                    sb.append((pl != 1 ? pl : "")+pStr);
                    pStr = nextStr; // 바아금 붙인 문자열을 새로운 앞추구로데에 진행
                    pl = 1; //문자열보다 새로운 압축개수가 더 나을지도
                }

            }
            sb.append(pStr);
            answer = Math.min(answer, sb.length());

        }
        System.out.println(answer);

    }
}
