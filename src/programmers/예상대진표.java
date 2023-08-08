package programmers;

public class 예상대진표 {
    public static void main(String[] args) {
        int N = 4;
        int A = 3;
        int B = 1;

        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int n = log2(N);
        while (n >= 1) {
            N = N / 2;
            if (min <= N && max > N) {
                System.out.println(n);
            } else if (max <= N) {
                n--;
            } else {
                min = min - N;
                max = max - N;
                n--;
            }
        }

    }

    public static int log2(int A) {
        return (int) (Math.log(A) / Math.log(2));
    }
}

