package programmers;

import java.util.Arrays;
import java.util.Map;

public class 최소직사각형 {
    // 안정적인 코드로 리펙토링하기 -> 내장함수 사용
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(findSolution(sizes));
    }

    static int findSolution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for (int[] card : sizes) {
            width = Math.max(width, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        return width*height;
}

//    static int findSolution(int[][] sizes) {
//        int[] answer1 = new int[sizes.length];
//        int[] answer2 = new int[sizes.length];
//
//        for (int i = 0; i < sizes.length; i++) {
//            if (sizes[i][0] > sizes[i][1]) {
//                answer1[i] = sizes[i][0];
//                answer2[i] = sizes[i][1];
//            }else {
//                answer1[i] = sizes[i][1];
//                answer2[i] = sizes[i][0];
//            }
//        }
//        Arrays.sort(answer1);
//        Arrays.sort(answer2);
//
//        return answer1[sizes.length-1]*answer2[sizes.length-1];
//    }
}
