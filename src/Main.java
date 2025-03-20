import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> x = rand.ints(5, 0, 11).boxed().collect(Collectors.toList());
        List<Integer> y = rand.ints(7, 0, 11).boxed().collect(Collectors.toList());

        x.sort(Integer::compareTo);
        y.sort(Integer::compareTo);

        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        xPlusY.sort(Integer::compareTo);

        Set<Integer> zSet = x.stream().filter(y::contains).collect(Collectors.toSet());

        List<Integer> xMinusY = x.stream().filter(num -> !y.contains(num)).collect(Collectors.toList());

        int p = 4;
        List<Integer> xPlusYLimitedByP = xPlusY.stream().filter(num -> num <= p).collect(Collectors.toList());

        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);
        System.out.println("xPlusY: " + xPlusY);
        System.out.println("zSet (valori comune): " + zSet);
        System.out.println("xMinusY: " + xMinusY);
        System.out.println("xPlusYLimitedByP: " + xPlusYLimitedByP);
    }
}
