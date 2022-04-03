import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int x;
    int y;

    Pair(int u, int v) {
        x = u;
        y = v;
    }

}

class k_closest_element {
    public static void function(int arr[], int x, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.y - a.y;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
        }

        // System.out.println();
        for (int i = k; i < arr.length; i++) {
            int val = Math.abs(x - arr[i]);
            if (pq.peek().y > val) {
                pq.poll();
                // System.out.println(p.x+" "+p.y);
                pq.add(new Pair(arr[i], val));
            }

        }

        for (int i = 0; i < k; i++) {
            Pair val = pq.poll();
            System.out.print(val.x + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = { 20, 40, 5, 100, 150 };
        int x = 100;
        int k = 3;
        function(arr, x, k);
    }
}
