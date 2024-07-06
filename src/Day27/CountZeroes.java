package Day27;

import java.io.*;
public class CountZeroes {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new SolutionCZ().countZeroes(arr, n);
            System.out.println(ans);
        }
    }
}

class SolutionCZ {
    int countZeroes(int[] arr, int n) {


        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] == 0) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return n - end - 1;
    }

}
