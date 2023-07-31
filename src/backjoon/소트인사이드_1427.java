package backjoon;

import java.util.Scanner;

public class 소트인사이드_1427 {  // 선택정렬
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        // 문자열로 받고 정수형으로 변환해준다. // 여기서 일단 하나 들어가고
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));   // 새로운거 배워간다 substring(시작i, 끝i)
        }
        // Max 값 찾기
        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i + 1; j < str.length(); j++) {    // 항상 범위값에서 문제가 생기네
                if (A[j] > A[Max]) {
                    Max = j;
                }
            }
            // 현재 i와 Max값 중 Max가 크면 swap
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for (int n : A) {
            System.out.print(n);
        }
    }
}
//Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        ArrayList <Integer> arr = new ArrayList<>();
//        while (N >0){
//            arr.add(N%10);
//            N =(N/10);
//        }
//        for (int i=0; i<N-1; i++){    // 버블정렬ㄹ이랑 범위가 헷갈린다. 손코딩ㅇ으로 이유 적어두기
//            int max_index = i;
//            for(int j=0; j<N-1-i;j++){    // 이러면 값이 가다가만다.. 버블정렬이 아니다. 주의하기
//                if (arr.get(max_index)< arr.get(j+1)){
//                    max_index = j+1;
//                    System.out.println("maxI"+ max_index);
//                }
//            }
//            int temp = arr.get(i);
//            arr.add(i, arr.get(max_index));
//            arr.add(max_index, temp);
//        }
//        for(int n : arr){
//            System.out.println(n);
//        }