package swea.구현;

import java.util.Scanner;

public class D2_날짜계산기_1948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int mon1;
        int day1;
        int mon2;
        int day2;
        int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int total1;
        int total2;

        for (int tc = 1; tc <= t; tc++) {
            mon1 = sc.nextInt();
            day1 = sc.nextInt();
            mon2 = sc.nextInt();
            day2 = sc.nextInt();
            total1 = 0;
            total2 = 0;

            // 날짜 계산
            for (int i = 0; i < mon1; i++) {
                total1 += days[i];
            } total1 += day1;

            for (int i = 0; i < mon2; i++) {
                total2 += days[i];
            } total2 += day2;

            System.out.println("#"+tc+" "+(total2-total1+1));
        }
    }
}
