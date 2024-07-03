package Day24;

import java.io.*;
public class SearchInRotatedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[] A = new int[n];
            String[] s = in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(n, A, key));
        }
        out.close();
    }
}
class Solution {
    int search(int n, int[] arr, int target) {
        int start = 0;
        int end = n-1;

        while (start <= end) {

            int mid = start + (end-start)/2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left Side Sorted
            if (arr[start] <= arr[mid]) {

                if (target <= arr[mid] && target >= arr[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

            // Right Side Sorted
            else {

                if (target <= arr[end] && target >= arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}