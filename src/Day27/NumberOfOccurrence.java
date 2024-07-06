package Day27;

import java.io.*;
public class NumberOfOccurrence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new SolutionNOO().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
class SolutionNOO {

    int occur(int[] arr, int n, int x, boolean first) {

        int ans = -1;

        int start = 0;
        int end = n-1;

        while (start <= end) {

            int mid = start + (end-start)/2;

            if (arr[mid] == x) {
                ans = mid;

                if (first)
                    end = mid - 1;

                else
                    start = mid + 1;
            }

            else if (arr[mid] > x) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    int count(int[] arr, int n, int x) {
        int first = occur(arr, n, x, true);
        int last = occur(arr, n, x, false);

        if (first == -1 || last == -1) {
            return 0;
        }

        return last - first + 1;
    }
}
