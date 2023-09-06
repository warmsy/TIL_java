package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];    // 배열 만들어주기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);   // 정렬
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }   // M개의 수를 받아주는 배열 세팅.

        for (int i = 0; i < M; i++) {
            int min = 0;    // min 값의 인덱스
            int max = N - 1;    // max 값의 인덱스
            boolean hasNum = false;
            while (min <= max) {
                int mid = (min + max) / 2;
                // N의 값은 최대 100,000 이니까 합해봤자 200,000 아래임.
                // 그래서 mid 의 타입은 int 여도 됨.
                if (targets[i] == numbers[mid]) {
                    // targets[i] = 1; 여기서 타겟값이랑 넘버값이 같으면 값을 1로 바꿔줌.
                    hasNum = true;
                    break;
                } else if (targets[i] > numbers[mid]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
//            if (targets[i] != 1) {
//                // 여기서 실수인 것 같다. 타겟이 1이고 넘버에 1이 없을 때
//                // 그래도 타겟은 1일테니 0이 안들어가겠지.
//                targets[i] = 0;
//            }
            if (hasNum) targets[i] = 1;
            else targets[i] =0;
        }
        for (int i : targets) {
            System.out.println(i);
        }


    }
}
