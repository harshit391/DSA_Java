package Day11;

import java.io.*;

class MaximumArraySubCircularSum {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine2 = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }

            System.out.println(SolutionMSACS.circularSubarraySum(arr, n));
        }
    }
}
class SolutionMSACS {

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {

        if (n == 1) {
            return a[0];
        }

        int sum = 0;
        for (int i : a) sum += i;

        int cMx = a[0];
        int mxF = a[0];
        int cMn = a[0];
        int mnF = a[0];

        for (int i=1; i<n; i++) {

            cMx = Math.max(cMx + a[i], a[i]);
            mxF = Math.max(mxF, cMx);

            cMn = Math.min(cMn + a[i], a[i]);
            mnF = Math.min(mnF, cMn);
        }

        if (mnF == sum) return mxF;

        return Math.max(mxF, sum - mnF);

    }

}


