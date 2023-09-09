package programmers;

import java.util.*;

public class 주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT"
                ,"18:00 0202 OUT","23:58 3961 IN" };
        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) {
        int[][] recordTable = new int[records.length][3];
        Comparator<Integer> comparator = (s1,s2) -> s1.compareTo(s2);
        Map<Integer, Integer> answer = new TreeMap<>(comparator);

        // 1. records 값 쪼개주기
        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" "); // record 값을 공백 단위로 split.
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    recordTable[i][j] = Integer.parseInt(temp[j].substring(0, 2)) * 60 +
                            Integer.parseInt(temp[j].substring(3));
                } else if (j == 1) {
                    recordTable[i][j] = Integer.parseInt(temp[j]);
                    answer.put(Integer.parseInt(temp[j]), 0);
                } else {
                    if (temp[j].equals("IN")) recordTable[i][j] = 1;
                    else recordTable[i][j] = -1;
                }
            }
        }
        // 2. recordTable 의 차량 번호에 따라 정렬해주기
        Arrays.sort(recordTable, Comparator.comparingInt((int[] o) -> o[1]));
        for (int i = 0; i < recordTable.length; i++) {
            System.out.println("시간 : " + recordTable[i][0] +
                    "  차량번호 : " + recordTable[i][1] +
                    "  출입 : " + recordTable[i][2]);
        }

        if (records.length > 1) {
            for (int i = 1; i < recordTable.length; i++) {
                int currentCarNum = recordTable[i][1];
                int currentCarTime = recordTable[i][0];
                int currentCarInOut = recordTable[i][2];

                int previousCarNum = recordTable[i - 1][1];
                int previousCarTime = recordTable[i - 1][0];
                int previousCarInOut = recordTable[i - 1][2];
                if (currentCarNum == previousCarNum) {
                    if (currentCarInOut == -1) {
                        answer.replace(currentCarNum,
                                answer.get(currentCarNum) + currentCarTime - previousCarTime);
                        recordTable[i][2] = 0;
                        recordTable[i - 1][2] = 0;
                    }
                    if (i == recordTable.length-1 && previousCarInOut==0){
                        int maxTime = 23 * 60 + 59;
                        answer.replace(currentCarNum,
                                answer.get(currentCarNum) + maxTime - currentCarTime);
                    }
                } else {
                    if (previousCarInOut == 1) {
                        int maxTime = 23 * 60 + 59;
                        answer.replace(previousCarNum,
                                answer.get(previousCarNum) + maxTime - previousCarTime);
                    }
                }


            }
        } else {
            int maxTime = 23 * 60 + 59;
            answer.replace(recordTable[0][1],
                    answer.get(recordTable[0][1]) + maxTime - recordTable[0][0]);
        }

        int[] parkingCost = new int[answer.size()];
        int idx = 0;
        for (int time : answer.values()) {
            if (time > fees[0]) {
                parkingCost[idx] = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            } else {
                parkingCost[idx] = fees[1];

            }
            System.out.println(parkingCost[idx]);
            idx++;
        }
        return parkingCost;

    }

}

