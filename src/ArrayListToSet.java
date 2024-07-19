import java.util.*;

public class ArrayListToSet {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Set<Integer> set = new HashSet<>(list);

        StringBuilder s1 = new StringBuilder("ans");
        StringBuilder s2 = new StringBuilder("ans");


        System.out.println(set);
    }
}
