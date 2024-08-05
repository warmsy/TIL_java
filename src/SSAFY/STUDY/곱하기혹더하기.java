package SSAFY.STUDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱하기혹더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char [] numbers = str.toCharArray();

        int total = 0; // 20억 이하니까 int로 해도 괜찮

        for (char n : numbers) { // 첫글자는 더해주는데, 첫글자가 0으로 오는 경우도 있으니 주의할것
            if (total == 0 || n == '0') { // 논리상 어차피 0이면 계산 제낄건데 total이 0이 아닌게 더 중요하니까 total을 앞으로 뺐음
                total += (n - '0');
            } else total = total * (n - '0');
        }
        System.out.println(total);
    }
}
