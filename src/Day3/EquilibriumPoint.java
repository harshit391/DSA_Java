package Day3;

import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long[] arr = new long[n];
            String[] inputLine = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            //calling equilibriumPoint() function
            System.out.println(SolutionEqPoint.equilibriumPoint(arr, n));
        }
    }
}

class SolutionEqPoint {


    public static int equilibriumPoint(long[] arr, int n) {

        long sum = 0;
        for (long i : arr) {
            sum += i;
        }

        long start = 0;
        sum -= arr[0];

        if (start == sum) {
            return 1;
        }

        for (int i=1; i<n; i++) {
            if (start == sum) {
                return i;
            }

            start += arr[i-1];
            sum -= arr[i];
        }

        return -1;
    }
}
