package Day2;

import java.io.*;
import java.lang.*;

class MoveAllNegetiveToTheEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[(int)(n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            obj.segregateElements(a, n);

            for (int i = 0; i < n; i++) ot.print(a[i] + " ");

            ot.println();
        }
        ot.close();
    }
}

class Solution {

    public void segregateElements(int[] arr, int n) {
        int[] ans = new int[n];

        int pos = 0;
        int neg = 0;

        for (int i : arr) {
            if (i >= 0) pos++;
        }

        int idx1 = 0;
        int idx2 = pos;

        for (int i : arr) {
            if (i >= 0) {
                ans[idx1++] = i;
            } else {
                ans[idx2++] = i;
            }
        }

        for (int i=0; i<n; i++) {
            arr[i] = ans[i];
        }

    }
}