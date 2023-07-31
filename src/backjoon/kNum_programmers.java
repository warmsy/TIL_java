package backjoon;

import java.util.Arrays;

public class kNum_programmers {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];

        // 값 받기
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] ;
            int end = commands[i][1];
            int k = commands[i][2] ;
            // 배열 자르기
            int[] target = Arrays.copyOfRange(array, start-1, end);
            // 정렬
            Arrays.sort(target);

            // k번째 수 추출하기
            int kNum = target[k-1];
            // answer에 삽입하기
            answer[i] = kNum;
        }
        for (int n : answer) System.out.println(n);
    }
}
