package SSAFY.STUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int convert0 = 0;
        int convert1 = 0;

        // 처음부터 돌려보며 total count 의 대소비교 후 더 작은 수 선택
        // 노가다를 넘 두려워하지말게... 그래봤자 십만건 돌리는게 다임
        if (num.charAt(0) == '1') convert0++;
        else convert1++;

        for (int i = 0; i < num.length() - 1; i++) {
            // 내부 요소 살피는데, i번쨰랑 i+1번째가 같다면
            if (num.charAt(i) != num.charAt(i + 1)) {
                // 근데 i+1의 요소가 1이라면?
                if (num.charAt(i+1) == '1') {
                    convert0 ++;
                }else convert1 ++;
            }
        }

        System.out.println(Math.min(convert0, convert1));

    }
}
