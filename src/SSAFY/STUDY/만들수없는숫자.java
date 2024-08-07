package SSAFY.STUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 만들수없는숫자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

         ArrayList<Integer> arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrayList.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arrayList);

            int target = 1;
            for (int i = 0; i < N; i++) {
                if (target < arrayList.get(i))
                    break;
                target += arrayList.get(i);
            }

            System.out.println(target);


    }
}
