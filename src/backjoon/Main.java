package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 1. 필요한 값을 받아주기 위한 변수 초기화
        int S = Integer.parseInt(st.nextToken());   // 받을 문자열의 길이
        int P = Integer.parseInt(st.nextToken());   // 비밀번호의 길이
        checkArr = new int[4];   // 비밀번호를 만들 조건을 담아주는 배열
        myArr = new int[4];   // 슬라이딩으로 받아온 문자들의 갯수를 담아주는 배열
        char A[] = new char[S]; // 전체길이 문자를 담아주는 배열
        checkSecret = 0;    // 현재 문자 중 몇개가 조건을 충족하는지 체크해주는 변수, 비밀번호 조건을 모두 충족하면 4가되고 result값이 1오른다.
        int result = 0; // 조건을 충족하는 경우의 수
        // 2. 문자열의 전체길이를 받아 char 배열로 바꿔줌
        A = bf.readLine().toCharArray();
        // 3. 비밀번호 조건을 받아줌.
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;    // 만약 필요한 문자열이 아니라면 비밀번호를 만들 떄 고려하지 않기 위함.
        }
        // 4. 부분 문자열 처음 받아 세팅
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) result++; // 처음 받아온 문자열에서 조건을 충족하는지 확인

        // 5. 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i - P;  // 처음 자리와 끝자리의 값만 뺴고 더해주며 문자열을 범위내에서 이동시킴.
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) result++; // 각 이동 떄 마다 조건을 충족하는지 여부 확인해주기
        }
        System.out.println(result);
        bf.close();
    }
    // swich문을 사용해서 조건에 맞을 떄 마다 값을 추가하고 뺴주기
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}