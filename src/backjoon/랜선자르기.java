package backjoon;

import javax.lang.model.type.IntersectionType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 랜선자르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lines = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(st.nextToken());
            lines[i] = line;
            max = Math.max(max, line);
        }
        int min = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int line : lines) {
                sum += line / mid;
            }
            if (sum >= n) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);

    }
}
