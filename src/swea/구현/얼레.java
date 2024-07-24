package swea.구현;

public class 얼레 {
    public static void main(String[] args) {
//        int r = 6;
//        int c= 3;
//        int k = 10;
//        int [][]arr = new int[r][c];
//
//        for (int j = 0; j < c; j++) {
//            for (int i = 0; i < r; i++) {
//                arr[i][j] = k++;
//            }
//        }
//
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }


        String str1 = "Hello";
        String str2 = str1;

        String str3 = new String ("Hello");
        String str4 = str3;

        System.out.println("str1 str2 : "+str1 == str2);
        System.out.println("str1 str2 eq : "+str1.equals(str2));
        System.out.println("str1 str3 : "+str1 == str3);
        System.out.println("str1 str3 : "+str1.equals(str3));
        System.out.println("str3 str4 : "+str3 == str4);
        System.out.println("str3 str4 : "+str3.equals(str4));

        // == 주소 비교? / equals 내용 비교 -> 결론 : ==주소비교 equal 내용비교



    }
}
