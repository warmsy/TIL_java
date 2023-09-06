package backjoon;

import java.util.Scanner;

public class 섬의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println();
        int temp1 = a;
        int cnt =0;
        boolean b = true;
        while (b){
            int temp2 = temp1/10 + temp1%10;    // 각 자리수 합한 새로운 수
            temp1 = (temp1%10)*10 + temp2%10;   // 새로운 수
            cnt ++;
            if (a == temp1) b= false;
        }
        System.out.println(cnt);
    }
    }
