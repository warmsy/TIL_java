package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드게임 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 1. 값 세팅
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        // 2. 큐에 값 삽입
        for (int i=1; i<= N; i++){
            queue.offer(i);
        }
        // 3. backjoon.카드게임 돌리기
        while (queue.size()>1){ // 큐에 값이 하나만 남을 때 까지 반복
            queue.poll();   // 첫 번째 카드 버림
            queue.offer(queue.poll());  // 두번째 카드 맨 뒤로 넣기
        }
        System.out.println(queue.peek());   // 큐의 맨 마지막 값 꺼내 출력
    }
}
