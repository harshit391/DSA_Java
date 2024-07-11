package Day32;

import java.io.*;
import java.util.*;

public class ProductPair {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            long x = Long.parseLong(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            boolean ans = new SolutionPP().isProduct(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

class SolutionPP {
    boolean isProduct(int[] arr, int n, long x) {
        if (n < 2) return false;

        HashSet<Long> set = new HashSet<>();

        for (int i=0; i<n; i++) {
            if (arr[i] == 0) {
                if (x == 0) {
                    return true;
                } else {
                    continue;
                }
            }

            if (x % arr[i] == 0) {
                long curr = x/arr[i];
                if (set.contains(curr)) {
                    return true;
                }
            }
            set.add((long)arr[i]);

        }
        return false;
    }
}