import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 3) Реализовать алгоритм пирамидальной сортировки (HeapSort).

public class Heapsort {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        int[] array = new int[]{19, 122, 16, 318, 3, -1, 3};
        Arrays.stream(array).forEach(element -> pq.add(element));

        while(pq.size() > 0){
        System.out.print(pq.poll() + " ");
    }
    }
}
