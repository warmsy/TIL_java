package programmers.그리디;


import java.util.ArrayList;

public class 모의고사 {
    public static void main(String[] args) {
        int [] answer1 = {1,2,3,4,5};
        int [] answer2 = {1,3,2,4,2};

        int [] finalA = solution(answer2);
        for (int i : finalA) {
            System.out.println(i);
        }
    }

    static int[] solution(int[] answer) {
        int[] number1 = {1, 2, 3, 4, 5};
        int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        for (int i = 0; i < answer.length; i++) {
            int dap = answer[i];
            int mun1 = i%number1.length;
            int mun2 = i%number2.length;
            int mun3 = i%number3.length;
            if (dap == number1[mun1]) score[0] ++;
            if (dap == number2[mun2]) score[1] ++;
            if (dap == number3[mun3]) score[2] ++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                arr.add(i + 1);
            }
        }

        int[] finalA = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            finalA[i] = arr.get(i);
        }
        return finalA;
    }
}
