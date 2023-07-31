package backjoon;

public class 가장큰수_programmers {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
//        int [] numbers = {3, 30, 34, 5, 9};
        // 1. 수를 이어 붙이기 위해 string으로 바꿔줌
        String[] stringArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringArr[i] = String.valueOf(numbers[i]);
        }
        int size = fact(numbers.length);
        long[] numberArr = new long[size];
        for (int i=0; i<numbers.length;i++){
            StringBuffer sb = new StringBuffer();
//            sb.append()
        }


    }

    private static int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }
}
