package programmers;

public class 타겟넘버 {
    static int count = 0;
    static void dfs(int[] numbers, int target, int depth, int total){
        if (depth == numbers.length){
            if (target == total){
                count ++;
            }
            return;
        }
        int plus = total + numbers[depth];
        int minus = total - numbers[depth];

        dfs(numbers, target, depth+1, plus);
        dfs(numbers, target, depth+1, minus);
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int depth =0;
        int total =0;
        dfs(numbers, target, depth, total);
        int answer = count;
        System.out.println(answer);
    }
}
