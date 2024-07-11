package Day32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PairWithDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }

        int B = scan.nextInt();

        System.out.println(new Solution().solve(list, B));
    }
}

class Solution {
    public int solve(ArrayList<Integer> A, int B) {

        int start = 0;
        int end = 1;

        Collections.sort(A);
        B = Math.abs(B);

        while (end < A.size()) {
            if (A.get(end) - A.get(start) < B) {
                end++;
            }

            else if (A.get(end) - A.get(start) > B ) {
                start++;
                if (start == end) end++;
            }

            else return 1;
        }

        return 0;
    }
}
