package Day26;

import java.io.*;
import java.util.*;

class AggressiveCow {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            int res = Solution.solve(n, k, v);

            System.out.println(res);
        }
    }
}

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[n-1] - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            int count = 1;
            int i = 0;
            int j = 1;
            while (j < n) {
                if (stalls[j] - stalls[i] >= mid) {
                    count++;
                    i = j;
                }
                j++;
            }

            if (count >= k) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
