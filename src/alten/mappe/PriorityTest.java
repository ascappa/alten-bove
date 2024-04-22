package alten.mappe;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityTest {
    public static void main(String[] args) {
        Comparator<UtenteSportello> utenteSportelloComparator = new Comparator<UtenteSportello>() {
            @Override
            public int compare(UtenteSportello o1, UtenteSportello o2) {
                return 0;
            }
        };

        PriorityQueue<UtenteSportello> codaUtenti = new PriorityQueue<>(utenteSportelloComparator);
    }
}
