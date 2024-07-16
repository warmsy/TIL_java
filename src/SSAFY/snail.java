package SSAFY;
import java.util.Arrays;
import java.util.Scanner;

public class snail {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] chars = new char[r][c];

        printSnail(r, c, chars);
    }

    private static void printSnail(int r, int c, char [][] chars) {
        int round = 1;  // 몇 번째 도는지 추적하는 변수
        int cnt = 0; // 순회한 전채 개수 추적하는 변수
        int nr = 0; // 현재 행의 위치
        int nc = 0; // 현재 열의 위치
        char init = 'A'; // 채울 문자
        int init2 = 1; // 채울 숫자 (테스트용)

        // 배열의 모든 요소 순회
        while (cnt < r * c) {
            // 오른쪽으로 이동
            for (int j = nc; j < c - round + 1 ; j++) {
                chars[nr][j] = init++; // 문자 채우고 증가
                cnt++; // 채운 개수 증가
                nc = j; // 열 위치 업데이트
            }
            nr++; // 행 위치 증가 (아래로 이동하기 위함)

            // 아래로 이동
            for (int i = nr; i < r - round + 1 ; i++) {
                chars[i][nc] = init++; // 문자 채우고 증가
                cnt++; // 채운 개수 증가
                nr = i; // 행 위치 업데이트
            }
            nc--; // 열 위치 감소 (왼쪽으로 꺾기 위함)

            // 왼쪽으로 이동
            for (int j = nc; j >= round - 1 ; j--) {
                chars[nr][j] = init++;
                cnt++;
                nc = j;
            }
            nr--; // 행 위치 감소 (위로 이동하기 위함)

            // 위로 이동
            for (int i = nr; i >= round ; i--) {
                chars[i][nc] = init++;
                cnt++;
                nr = i;
            }
            nc++; // 열 위치 증가 (오른쪽으로 이동하기 위함)
            round++; // 다음 라운드로!
        }

        // 예쁘게 출력하기
        for (char[] arr : chars) {
            for (char a : arr) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

}

