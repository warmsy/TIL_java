package backjoon.구현;

import java.util.Scanner;

public class 분산처리_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt() % 10;
            int b = sc.nextInt();
            if (a == 0) {
                System.out.println(10);
            } else if (a == 1 || a == 5 || a == 6) {
                System.out.println(a);
            } else if (a == 2) {
                int[] arr = {2, 4, 8, 6};
                int idx = (b - 1) % arr.length;
                System.out.println(arr[idx]);
            } else if (a == 3) {
                int[] arr = {3, 9, 7, 1};
                int idx = (b - 1) % arr.length;
                System.out.println(arr[idx]);
            } else if (a == 4) {
                int[] arr = {4, 6};
                int idx = (b - 1) % arr.length;
                System.out.println(arr[idx]);
            } else if (a == 7) {
                int[] arr = { 7, 9, 3, 1};
                int idx = (b - 1) % arr.length;
                System.out.println(arr[idx]);
            } else if (a == 8) {
                int[] arr = {8, 4, 2, 6};
                int idx = (b - 1) % arr.length;
                System.out.println(arr[idx]);
            } else {
                int[] arr = {9, 1};
                int idx = (b - 1) % arr.length;
                System.out.println(arr[idx]);
            }
        }

        sc.close();
    }
}

/* 제곱 처리가 어려웠어...
내가 구현에 약하구나...
import java.util.Scanner;

public class Main {
    	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int a, b,answer;
		for(int i=0; i<T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			answer = 1;
            for (int j=0; j<b;j++){
                answer = (answer* (a%10))%10;
            }
            if (answer == 0){
                answer = 10;
            }
			System.out.println(answer);
		}
	}
}
*/


