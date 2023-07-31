package programmers;

public class 비밀지도 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        String[] answer = new String[n];
        String[] arr1Binary = new String[n];
        String[] arr2Binary = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i]);
            while (temp.length() < n) {
                temp = "0" + temp;
            }
            arr1Binary[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr2[i]);
            while (temp.length() < n) {
                temp = "0" + temp;
            }
            arr2Binary[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if (arr1Binary[i].charAt(j) == '0' && arr2Binary[i].charAt(j) == '0') {
                    s = s + " ";
                } else {
                    s = s + "#";
                }
            }
            answer[i] = s;
        }



        for (String s : answer) {
            System.out.println(s);
        }
//        for(int i=0; i<n; i++){
//            String s = "";
//            for(int j =0; j<n; j++){
//                if(arr1Binary[i].charAt[j] == '0' && arr2Binary[i].charAt[j] == '0'){
//                    s = s+ " ";
//                }
//                else {
//                    s = s+"#";
//                }
//            }
//            answer[i] = s;
//        }
    }
}
