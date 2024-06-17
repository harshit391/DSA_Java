package Day8;

import java.io.*;
import java.util.*;

class Solution {
    long countTriplets(long[] arr, int n, int sum) {
        Arrays.sort(arr);

        int count = 0;

        for (int i=0; i<n-2; i++) {
            int l = i+1;
            int r = n-1;

            while (l < r) {
                if (arr[i] + arr[l] + arr[r] >= sum) {
                    r--;
                } else {
                    count += r - l;
                    l++;
                }
            }
        }

        return count;
    }
}

class CountTripletSumSmallerThanX {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        while (testcases-- > 0) {

            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }

            Solution ob = new Solution();
            long ans=ob.countTriplets(a,n,k);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends