package backjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 단어의개수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.strip();
        if (str.isEmpty()) System.out.println(0);
        else {
            String[] arr = str.split(" ");
            System.out.println(arr.length);
        }
    }
}

//
//str = str.strip();
//int cnt = 0;
//        for (char ch : str.toCharArray()) {
//        System.out.println(str.toCharArray().toString());
//        if (ch==' ') cnt ++;
//        }
//        System.out.println(cnt== 0? cnt : cnt+1);
//// 반례 : 단어가 하나만 등장할 때