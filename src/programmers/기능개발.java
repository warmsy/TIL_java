package programmers;

import java.util.*; // 그냥 자바 util import 하기

public class 기능개발 {
    public static void main(String[] args) {
//        int[] progresses = {90, 30, 55};
//        int[] speeds = {1, 30, 5};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 60, 5};
//        int[] progresses = {20, 99, 93, 30, 55, 10};
//        int[] speeds = {5, 10, 1, 1, 30, 5};
//        20, 99, 93, 30, 55, 10], [5, 10, 1, 1, 30, 5
        int[] answer = Solution(progresses, speeds);
        for (int n : answer) System.out.println(n);
    }

    private static int[] Solution(int[] progresses, int[] speeds) {
        
        Stack<Integer> workDays = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();  // 정답을 담아줄 arrayList
        // 스택에 작업일 담아주기
        for (int i = progresses.length - 1; i >= 0; i--) {
            double remain = (double) (100 - progresses[i]) /speeds[i];
            int date = (int) Math.ceil(remain);
            workDays.push(date);
        }

        int cnt = 1;
        int maxDay = workDays.pop();
        while (!workDays.isEmpty()) {
            int workday = workDays.pop();
            if (!workDays.isEmpty()) {
                if (workday >= workDays.peek() || maxDay>workDays.peek()) {
                    cnt++;
                } else {
                    answer.add(cnt);
                    cnt = 1;
                    maxDay = workDays.peek();
                }
            } else {
                answer.add(cnt);
            }
        }
        int [] a = new int[answer.size()];
        for (int i=0; i<answer.size();i++){
            a[i] = answer.get(i);
        }
        return a;
    }
}

//        String a = "1234";
//        String[] c = a.split("");
//        int[] b = new int[c.length];
//        for (int i = 0; i < c.length; i++) {
////            b[i] = Integer.parseInt(c[i]);
//            System.out.println(Integer.parseInt(c[i]));