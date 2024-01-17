package programmers.스택큐;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        for (int n : solution(prices)) {
            System.out.println(n);
        }

    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // 1. price 값 하나씩 확인해보면서 조건에 맞으면 answer에 기록, 아니면 스택에 넣어주는 코드
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 만약에 스택에 값이 있고(스택에 들어있는 값 = 처음 시간 or 끝까지 떨어지지 않은 각겨의 시간)
                // 주식 가격이 스택의 넣은 시간의 가격보다 낮으면 가격이 떨어졌기 때문에 answer 에 떨어진 시간을 넣어주고
                // stack 에서 값을 제거한다.
                answer[stack.peek()] = i - stack.pop(); // stack에 넣은 시점 기준으로 현재까지니까
            }
            stack.push(i);  // 아니면 걍 스택에 넣어주고
        }

        // 마지막까지 가격이 떨어지지 않아 stack 에 남아있는 값 시간 계산해주기
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - 1 - stack.pop(); // 전체길이에서
        }
        return answer;

    }
//    private static int[] solution(int[] prices) {
//
//        int[] answer = new int[prices.length];
//        Stack<Integer> stack = new Stack<>();
//        int minPrice, minTime;
//        int totalTime = prices.length;
//        int currentPrice, currentTime;
//
//        for (int i : prices) {
//            stack.add(i);
//        }
//        currentTime = stack.size();
//        currentPrice = stack.pop();
//        minTime = currentTime;
//        minPrice = currentPrice;
//
//        while (!stack.isEmpty()) {
//            int afterTime = currentTime;
//            int afterPrice = currentPrice;
//            currentTime = stack.size();
//            currentPrice = stack.pop();
//
//            if (currentPrice <= afterPrice) {
//                if (minPrice >= currentPrice) {
//                    answer[currentTime - 1] = totalTime - currentTime;
//                    minTime = currentTime;
//                    minPrice = currentPrice;
//                } else {
//                    answer[currentTime - 1] = minTime - currentTime;
//                }
//            } else {
//                answer[currentTime - 1] = afterTime - currentTime;
//            }
//        }
//
//
//        return answer;
//    }
}
