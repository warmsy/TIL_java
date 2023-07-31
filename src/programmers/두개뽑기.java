package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 두개뽑기 {
    public static void main(String[] args) {
        int [] numbers = {5,0,2,7};

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length;j++){
                arr1.add(numbers[i]+numbers[j]);
            }
        }
        for(int n : arr1){
            if(!arr2.contains(n)){
                arr2.add(n);
            }
        }
        int[] answer = arr2.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        for(int a : answer){
            System.out.println(a);
        }



    }
}
