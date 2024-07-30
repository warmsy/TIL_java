package backjoon.DFS_BFS;

// 반성
// 아이디어 자체는 괜찮았지만.. 구현문제임에도
// dfs 로 풀려고 하다가 재귀 조건 잘못씀
// 굳이 dfs 로 풀어야 했을까? 이떈 while 문이 더 쉽다.

// 잘한 점
// outboundIndex 예상하고 방지책을 생각한건 좋음. 잘함
// boolean 배열과 idx 를 활용한 것도 나쁘지않았음

// 어려운 문제가 아닌데 .. 문제 유형 파악에 실패했나..
public class 셀프넘버_4673 {
    public static void main(String[] args) {
        // true false 담아줄 boolean 배열 생성
        boolean[] selfNum = new boolean[10001];
        // selfNum 이면 true, 아니면 false

        // 루프 돌며 판별해주기
        for (int i = 1; i <= 10000; i++) {
            int idx = isSelfNum(i);
            if (idx <= 10000) {
                selfNum[idx] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!selfNum[i]) {
                System.out.println(i);
            }


        }
    }

    private static int isSelfNum(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
