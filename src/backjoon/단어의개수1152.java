package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어의개수1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = line.strip();
        if (line.length() !=0){
            String [] arr = line.split(" ");
            System.out.println(arr.length);
        }
        else System.out.println(0);
    }
}
