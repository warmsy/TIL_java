package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i =0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i=0; i<N-1; i++){
            for (int j =0; j<N-1-i; j++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for(int num : arr) System.out.println(num);
    }
}
