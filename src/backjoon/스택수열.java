package backjoon;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) {
        // 1. 값 세팅
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        // A 배열에 값 넣어주기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        int stack_num = 1;  // 오름차순으로 넣어줄 자연수
        boolean operstionResult = true; // true면 부호 출력, false면 부호 출력 X
        StringBuffer bf = new StringBuffer();   // 부호를 담아주기 위함. 만약 문제조건과 달리 스택으로 구현 안되면 칼같이 No만 출력해줘야되서.
        // String operation = ""; 처음엔 string operation에 부호를 저장했는데 메모리 초과됨.ㅠ

        // 2. stack 값 비교
        for (int i = 0; i < N; i++) { // N 만큼 반복
            if (A[i] >= stack_num) {  // 배열의 값이 스택에 넣을 값 보다 크거나 같을 때
                while (A[i] >= stack_num) { // 배열의 값과 같아질 때 까지 반복하기
                    s.push(stack_num);
                    stack_num++;
                    // operation += "+\n";
                    bf.append("+\n");   // 부호 출력시 줄바꿈 필요해서
                }
                s.pop();
                // operation += "-\n";
                bf.append("-\n");
            } else {    // 배열의 값이 오름차순 자연수 보다 작을 때
                int temp = s.pop(); // stack에 담긴 값을 빼서
                if (temp > A[i]) {  // stack에서 뺀 값이 배열의 자연수보다 크면 차곡차곡 쌓인 stack의 아래값을 더 뺄 수 없어서
                    System.out.println("NO");   // 조건에 맞지 않아 NO를 출력해주고
                    operstionResult = false;    // operstionResult 를 false로 바꿔 부호가 출력되지 않도록 해준다.
                    break;
                } else {
                    // operation += "-\n";
                    bf.append("-\n");

                }
            }
        }

        // if(operstionResult) System.out.println(operation);
        if (operstionResult) System.out.println(bf.toString());
    }
}
