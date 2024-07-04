package Day25;

import java.util.*;
class BookAllocationProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            System.out.println(Solution.findPages(n, a, m));
        }
    }
}
class Solution {
    public static boolean check(int[] arr, int m, int s) {

        int count = 1;
        int sum = 0;

        for (int j : arr) {

            if (sum + j > m) {
                count++;
                sum = 0;
            }
            sum += j;
        }

        return count <= s;
    }

    public static long findPages(int n, int[] arr, int m) {
        if (n < m) {
            return -1;
        }

        int start = arr[n-1];

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int end = sum;

        long ans = Long.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (check(arr, mid, m)) {
                ans = Math.min(ans, mid);
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}