package programmers;

import java.util.ArrayList;

public class 소수만들기 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        ArrayList<Integer> list = new ArrayList<>();    // 소수 담아줄 리스트

        // 1. 뽑기
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (temp % 2 != 0)
                        list.add(temp);
                }
            }
        }

        // 2. 소수 판별
        int answer = list.size();
        for (int n : list) {
            for (int i = 3; i < n; i += 2) {
                if (n % i == 0) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);

    }


}


