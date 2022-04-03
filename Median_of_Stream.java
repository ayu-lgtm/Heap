import java.util.Collections;
import java.util.PriorityQueue;

public class Median_of_Stream {
    public static void main(String args[]) {
        int arr[] = { 25, 7, 10, 15, 20 };

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        pq1.add(arr[0]);
        System.out.print(pq1.peek() + " ");
        for (int i = 1; i < arr.length; i++) {
            if (pq1.size() > pq2.size()) {
                if (pq1.peek() > arr[i]) {
                    pq2.add(pq1.poll());
                    pq1.add(arr[i]);
                } else {
                    pq2.add(arr[i]);
                }

                System.out.print(((double) pq1.peek() + pq2.peek()) / 2 + " ");
            } else {
                if (pq1.peek() >= arr[i]) {
                    pq1.add(arr[i]);
                } else {
                    pq2.add(arr[i]);
                    pq1.add(pq2.poll());
                }
                System.out.print(pq1.peek() + " ");
            }
        }

    }
}
