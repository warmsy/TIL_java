package programmers;

import com.sun.jdi.LongValue;

import java.util.*;
import java.util.ArrayList;

public class n제곱자르기 {
    public static void main(String[] args) {
        for (int a : solution(4,7,14)){
            System.out.println(a+"  ");
        }
    }

    static int[] solution(int n, long left, long right) {
        ArrayList<Long> arr = new ArrayList<>();
        long leftRow, rightRow, leftCol, rightCol;

        if ((left + 1) % n == 0) {
            leftRow = (left + 1) / n;
            leftCol = n;
        } else {
            leftRow = (left + 1) / n + 1;
            leftCol = (left + 1) % n;
        }

        if ((right + 1) % n == 0) {
            rightRow = (right + 1) / n;
            rightCol = n;
        } else {
            rightRow = (right + 1) / n + 1;
            rightCol = (right + 1) % n;
        }
//        System.out.println("leftRow: " + leftRow + " leftCol: " + leftCol
//                + " rightRow: " + rightRow + " rightCol: " + rightCol);

        for (long i = leftRow; i <= rightRow; i++) {
            if (i == leftRow) {
                for (long j = leftCol; j <= n; j++) {
                    long temp = leftCol;
                    if (j <= i) {
                        arr.add(i);
                    } else arr.add(temp++);
                }
            }
            else if(i>leftRow & i<rightRow){
                for (long j = 1; j <= n; j++) {
                    long temp = i;
                    if (j <= i) {
                        arr.add(i);
                    } else arr.add(++temp);
                }
            }
            else {
                for (long j = 1; j <= rightCol; j++) {
                    long temp = i;
                    if (j <= i) {
                        arr.add(i);
                    } else arr.add(++temp);
                }
            }
        }
        int[] answer = arr.stream().mapToInt(Long::intValue).toArray();


        return answer;
    }
}
