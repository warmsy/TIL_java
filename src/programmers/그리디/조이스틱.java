package programmers.그리디;

public class 조이스틱 {
    public static void main(String[] args) {
        String name1 ="JEROEN";
        String name2 ="JAN";

        System.out.println(solution(name2));
    }

    static int solution(String name) {
        String AtoN = "ABCDEFGHIJKLMN";
        String ZtoO = "AZYXWVUTSRQPO";

        int move = name.length()-1;
        int count =0;

        int idx = 0;

        // 상하 조이스틱 이동 횟수
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) <= 'N') {
                count += AtoN.indexOf(name.charAt(i));
            } else {
                count += ZtoO.indexOf(name.charAt(i));
            }

            idx = i+1;
            // 연속된 A 개수 기반, A 뒷부분, A 앞부분 길이 판단
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx ++;
            }

            // 좌우 이동해서 어느쪽이 더 이득인가?
            move = Math.min(move, i*2+name.length()-idx);   // 순서대로 갈까 역순으로 갈까
            move = Math.min(move, (name.length()-idx)*2 + i); // 연속 A 부분이 있다면 앞부터 갈까 역순으로 갈까
        }
        return count+move;
    }

}
