package programmers.그리디;

import java.util.HashSet;
import java.util.Set;

public class 체육복 {
    public static void main(String[] args) {

        System.out.println(solve(5, new int[]{2,4}, new int[]{3}));
    }

    private static int solve(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // lost 중에서 체육복을 빌려줄 수 있는 사람들 집합
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        // 1. set 채우기
        for (int r : reserve) {
            reserveSet.add(r);
        }
        // 2. 중복 확인 (잃어버린애 = 여분 있는애)
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l); // 잃어버린 여분을 자신에게 줘서 빌려줄 수 있는 대상에서 제외
            } else lostSet.add(l);  // 진짜 잃어버린 애들만 넣어줌.
        }

        // 3. 잃어버린 애들과 빌려줄 애들 매칭
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);  // 빌려줄 애보다 사이즈 작은애가 잃어버리면 여분 빌려주고 잃어버린애에서 제외
            }
            else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);  // 빌려줄 애보다 사이즈 큰애면 여분 빌려주고 잃어버린 애에서 제외
                // 왜 if()가 아니라 else if 냐면 빌려줄 수 있는 애 중에서 잃어버린애 한번 카운트하고 지워버리려고
                // if로 들어가면 중복으로 빌려주는 의미가 됨.
            }
        }

        answer = n - lostSet.size();
        return answer;
    }
}
