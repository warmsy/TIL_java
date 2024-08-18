package STUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ChickenDelivery2 {
    private static int N, M;
    private static int[][] home, chicken;
    // 근데 arrayList로 할지 array로 할진 아직 정하진 못함
    // 걍 메모리도 넉넉한데 걍 copyof쓸걸.. ArrayList하고 어쩌고로 다시 풀어보는 연습을 해봐야지.. 쓸데없이 30분 날린듯
    private static int minDistance; // 최단거리
    private static int[][] chickenComb; // 살아남을 치킨가게 좌표를 담아줄 배열

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new int [N*2][2];    // 집의 최대 개수(100이하)
        chicken = new int[13][2];   // 치킨가게 최대값
        int homeCnt =0;
        int chickenCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int cell = Integer.parseInt(st.nextToken());
                if (cell == 1) {
                    home[homeCnt][0] = i;
                    home[homeCnt][1] = j;
                    homeCnt++;
                } else if (cell == 2) {
                    chicken[chickenCnt][0] = i;
                    chicken[chickenCnt][1] = j;
                    chickenCnt++;
                }
            }
        }
        home = Arrays.copyOf(home, homeCnt);
        chicken = Arrays.copyOf(chicken, chickenCnt);
        // 걍.. 편하게 보려고

//         상진썜 피셜 꼭 값이 제대로 들어왔는지 반드시!! 확인할 것
        System.out.println("home : "+Arrays.deepToString(home));
        System.out.println("chicken : "+Arrays.deepToString(chicken));
        // 잘 들어옴 확인 굿굿. 근데 다음부턴 출력도 순서대로 하길

        chickenComb = new int [M][2];   // 살아남을 치킨집의 조합을 담아줄 배열
        minDistance = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println("minDistance : "+ minDistance);

    }
    private static void comb(int cnt, int start){
        if (cnt == M) { //M개 뽑았으면? M이 여기로 들어가야지
            // 담아온 조합에서 치킨 조합마다 최소거리 구해주기
            int totalDistance = 0;
            for (int i = 0; i < home.length; i++) { // 각각의 집에서
                int shortestChickenStore =Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int d = Math.abs(home[i][0] - chickenComb[j][0]) + Math.abs(home[i][1] - chickenComb[j][1]);
                    shortestChickenStore = Math.min(shortestChickenStore, d);
                }// 여기까지 가장 짧은 거리의 치킨집 까지의 거리를 구하고
                totalDistance += shortestChickenStore;  // 가장 짧은 거리까지의 치킨집을 더해주는데
            }   // 다 구했으면 이제 조합마다 비교
            minDistance = Math.min(minDistance, totalDistance);
            return;
        }

        for (int i = start; i < chicken.length; i++) { // 전체 치킨 개수중에서
            chickenComb[cnt] = chicken[i];
            comb(cnt+1, i+1);
        }
        // 조합을 구해주고
    }

}


/* 소요시간 : 1시간 50분
 총평
 문제 풀이 생각엔 30분, 코드 구조 30분, 실제 구현 50분 실화냐
 구현 과정 오래걸린 이유 분석 :
    1) Array랑 ArrayList랑 뭐쓸지 고민하다가 중간에 섞어 써버림
        -> 줏대있게 살게 둘중 하나만 써라..
    2) 조합 코드구조에서 nCr일 떄 r의 위치가 어디인지 헷갈림
        -> 한번 더 생각해봤으면 좋은게 cnt가 전체 횟수가 되면 조합을 담아주는 배열은 터진다는 점에서
        종료조건 깊이가 r이 되야됨을 잊지 말길.
 추가 유의사항
    1) 어느 변수를 static으로 뽑을지는 일단 main 안에 써두고 바깥으로 뺄 필요성을 따져볼 것.
    2) 순조부 문제에서 종료조건 내부와 바깥쪽에 어디에 min max값을 넣어줄지 생각해봐야 함.
    햄버거 문제와 치킨배달 문제를 잘 떠올려 보고 문제를 풀어나갈 것.
 잘한 점
    코딩테스트 출제 됐을 떈 손도 못댔는데 이젠 푸네. 노력이 헛되지 않았음을 증명한 것 같아 기쁘다.
    하지만 쓸데없는 실수는 줄여서 다음엔 더 빠르게 코드 짜기. 약속.
*/


