package SSAFY.보충수업;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2048게임 {

    static int N;
    static int[][] board;
    // 내부의 값을 계산해주기 위한 queue
    // 왜 queue 썼냐면 배열 인덱스 관리 귀찮으니까
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        // 우석인가ㅏ 우식인가 Buffered 썻다 터져서 한동안 멀어집니다..
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            String direction = sc.next();

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            if (direction.equals("up")) {
                moveUp();   // 여기는 파라미터를 통해 함수 하나를 줄일 수 있긴하지만
                // 번거로워서 그냥 하나 더 만들었습니다..
            } else if (direction.equals("down")) {
                moveDown();
            } else if (direction.equals("left")) {
                moveLeft();
            } else if (direction.equals("right")) {
                moveRight();
            }
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }

    }

    // 위로 이동하면
    private static void moveUp() {
        for (int col = 0; col < N; col++) { // 열 고정
            for (int row = 0; row < N; row++) { // 행 변경
                if (board[row][col] != 0) { // 0이 아니면
                    queue.offer(board[row][col]);   // queue에 넣어주는데
                }
            }
            int row = 0;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (!queue.isEmpty() && current == queue.peek()) {
                    board[row][col] = current * 2;  // 큐 안비어있고 다음 수가 같으면 2곱함
                    queue.poll();   // 그리고 다음 수는 터쳐
                } else {
                    board[row][col] = current; // 아니면 도로 배열에 넣어
                }
                row++;
            }
            while (row < N) {   // queue에 넣은거 다 뺏으면 남은 자리 0채우기
                board[row][col] = 0;
                row++;
            }
        }
    }

    private static void moveDown() {
        for (int col = 0; col < N; col++) {
            for (int row = N - 1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    queue.offer(board[row][col]);
                }
            }
            int row = N - 1;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (!queue.isEmpty() && current == queue.peek()) {
                    board[row][col] = current * 2;
                    queue.poll();
                } else {
                    board[row][col] = current;
                }
                row--;
            }
            while (row >= 0) {
                board[row][col] = 0;
                row--;
            }
        }
    }

    private static void moveLeft() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] != 0) {
                    queue.offer(board[row][col]);
                }
            }
            int col = 0;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (!queue.isEmpty() && current == queue.peek()) {
                    board[row][col] = current * 2;
                    queue.poll();
                } else {
                    board[row][col] = current;
                }
                col++;
            }
            while (col < N) {
                board[row][col] = 0;
                col++;
            }
        }
    }

    private static void moveRight() {
        for (int row = 0; row < N; row++) {
            for (int col = N - 1; col >= 0; col--) {
                if (board[row][col] != 0) {
                    queue.offer(board[row][col]);
                }
            }
            int col = N - 1;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (!queue.isEmpty() && current == queue.peek()) {
                    board[row][col] = current * 2;
                    queue.poll();
                } else {
                    board[row][col] = current;
                }
                col--;
            }
            while (col >= 0) {
                board[row][col] = 0;
                col--;
            }
        }
    }
}