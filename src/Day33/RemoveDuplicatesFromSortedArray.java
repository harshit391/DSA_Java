package Day33;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int idx = new Solution().removeDuplicates(list);

        System.out.println(list.subList(0, idx));

    }
}

class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        int i=0;

        for (int j : a) {
            if (i < 1 || j > a.get(i-1)) {
                a.set(i, j);
                i++;
            }
        }

        return i;
    }
}
