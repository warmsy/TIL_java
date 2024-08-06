package SSAFY.STUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하나가될떄까지 {
    public static void main(String[] args) throws Exception {
        // 풀이
        // %k ==0 이 될 때까지 첫번쨰 반복
        // n이 1이 될 떄까지 두번째 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
//        while (n%k != 0) {
//            n--;
//            cnt ++;
//        }
//        while (n != 1) {
//            n /= k;
//            cnt ++;
//        } 참말로 거지같은 코드를 짯어잉
        while (n > 1) {
            if (n % k == 0) n /= k;
            else n -= 1;
            cnt++;
        }
        System.out.println(cnt);
    }

}
