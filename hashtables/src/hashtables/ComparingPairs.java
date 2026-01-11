package hashtables;

import java.util.Comparator;

// Implement the compare method. This method takes in two Pairs and compares them on the basis of their "value" (count).
public class ComparingPairs implements Comparator<Pair<String,Integer>> {

    public int compare(Pair<String,Integer> pair1, Pair<String,Integer> pair2) {
        return pair1.getValue().compareTo(pair2.getValue());
    }
}
