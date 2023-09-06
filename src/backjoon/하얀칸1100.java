package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하얀칸1100 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        // 1. for 문 돌며 문자열 가져오기
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            char[] arr = line.toCharArray();

            // 2. 문자열 위치가 홀짝인지 판별하고 말의 갯수 세기
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j += 2) {
                    if (arr[j] == 'F') cnt++;
                }
            } else {
                for (int j = 1; j < 8; j += 2) {
                    if (arr[j] == 'F') cnt++;
                }
            }
        }
        System.out.println(cnt);


    }
}
