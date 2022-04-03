import java.util.ArrayList;
import java.util.PriorityQueue;

class Triplet {
    int row_key;
    int column_key;
    int val;

    Triplet(int x, int y, int z) {
        row_key = x;
        column_key = y;
        val = z;
    }
}

public class Merge_k_sorted_Array {
    public static void function(int arr[][]) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((A, B) -> (A.val - B.val));

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Triplet(i, 0, arr[0][i]));
        }

        while (pq.isEmpty() == false) {
            Triplet t = pq.poll();
            al.add(t.val);
            int hp = t.row_key;
            int vp = t.column_key;
            if (vp + 1 < arr[hp].length) {
                pq.add(new Triplet(hp, vp + 1, arr[hp][vp + 1]));
            }
        }
        System.out.print(al + " ");
    }

    public static void main(String args[]) {
        int arr[][] = { { 4, 5, 6 },
                        { 3, 5, 6, 7 },
                        { 8, 9, 10, 11 } };

        function(arr);
    }
}
