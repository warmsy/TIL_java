package programmers.해쉬;

import java.util.*;

public class 폰켓몬 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int [] nums = {3,3,3,2,2,4};
        for (int i : nums) {
            set.add(i);
        }
        if (set.size() >= nums.length/2) System.out.println(nums.length / 2);
        else System.out.println(set.size());
    }
}
