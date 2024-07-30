import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 레이더_1210 {
    // 참고 ~ https://javaju.tistory.com/111
    static int[][] map = new int[100][100];
    //    static int N=100; // 문제 조건에서 100개라고 한정함
    static int[] dx = {-1, 0, 0}; // x 는 위로만 올라가니까 -1
    static int[] dy = {0, -1, 1}; // y는 양 옆으로만 움직이니까

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/res/input.txt")); // TC 받아올 파일
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 10; tc++) { // 문제에서 TC가 10이라고 함
            int t = Integer.parseInt(br.readLine()); // 테스트 케이스도 입력받음
            // 1. 한 줄씩 입력 받아오기
            /** 문제 조건 잘 보자 100개라고 했으니까!! */
            // String Arraylist vs 2dimension arraylist
            // 2. 줄마다 2가 있는지 탐색, 2가 있으면 입력 종료, 2의 위치 반환
            // 이러면 시간복잡도가 높아질 것 같음

            int arriveX = 0, arriveY = 0;
            for (int i = 0; i < map.length; i++) {
                // 여기서 map의 r만큼 문자를 받아오는구나
                st = new StringTokenizer(br.readLine()); // 한 줄씩 받아오는데
                for (int j = 0; j < map[0].length; j++) { // 이 줄의 길이에서
                    map[i][j] = Integer.parseInt(st.nextToken()); // st의 토큰의 개수를 하나씩 받아옴
                    if (map[i][j] == 2) { // 분명 여기서 2가 들어옴
                        arriveX = i;
                        arriveY = j;
                    }
                }
            }
            // 여기까지 배열 초기화 끝나면? 아래부터 위로 올라가는 코드 짜겟죠?
            int answer = move(arriveX, arriveY);  // 여기서 move()하는 코드 짜고
            sb.append("#").append(t).append(" ").append(answer).append("\n");

        }
        System.out.print(sb.toString()); // 추가 해놓고 나아아아중에 모아서 한방에 출력!!
        br.close();
    }

    static int move(int x, int y) {
        // 3. 2의 위치에서 역순으로 올라가기
        while (true) {
            // 배열을 도는데
            // 종료조건은? X가 0이 되면!
            if (x == 0) {
                return y;
            }
            // 여기서 방향을 탐색하는 코드를 넣어주는데
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == 1) {
                    map[nx][ny] = 3; // 이미 지나간 경로를 표시해 디버깅을 편하게 하기 위한 flag!!
                    x = nx;
                    y = ny;
                }
            }
        }
        //3-1. 처음엔 위쪽으로 올라가고
        // 3-2 다음 이동 땐 주위 탐색 -> 옆이 1인 곳을 먼저 들어가기
        // 진행 하다가 옆이면 계속 돌다가 옆이 1이 아니면, 위를 보기(아래는 X)
        // 위의 과정 반복!

        // 4. R이 0이 되는 구간을 만나면, 반복 끝내고 최종 C의 좌표 반환하기

    }
}



/* 여기서부턴 강사님 코드
public class Solution_d4_1210_Ladder1_지역_반_홍길동{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		int T=10;//Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
			int N=Integer.parseInt(br.readLine());
			int[][] a=new int[100][100];
			int two=0;
			for(int i=0; i<100; i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<100; j++){
					a[i][j]=Integer.parseInt(st.nextToken());
					if(a[i][j]==2) two=j;
				}
			} // 여기까지 하고 값을 잘 받아왔는지 확인하는 코드 삽입
			//for(int[] b:a) System.out.println(Arrays.toString(b));System.out.println();

            int i=99,j=two;
            while(i!=0){
            	a[i][j]=0;
            	     if(0<=j-1     && a[i][j-1]==1) j--;//좌
            	else if(   j+1<100 && a[i][j+1]==1) j++;//우
            	else                                i--;//상
            }
            sb.append("#").append(tc).append(" ").append(j).append("\n");
        }
		System.out.println(sb.toString());
		br.close();
    }
}
/*
1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 2
*/


