package backjoon;

import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.offer(3);

        System.out.println(queue.element());
        System.out.println(queue.peek());

        Queue<String> queue2 = new LinkedList<>();
        queue2.offer("First");
        queue2.offer("Second");
        queue2.offer("Third");

        // Using forEach to process each element in the backjoon.queue
        queue2.forEach(System.out::println);

    }
}
