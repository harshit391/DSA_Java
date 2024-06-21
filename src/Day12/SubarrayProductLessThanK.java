package Day12;

import java.util.*;
import java.lang.*;
import java.io.*;


class SubarrayProductLessThanK {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());

            long[] a = new long[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));
        }
        out.close();
    }
}


class Solution {


    public long countSubArrayProductLessThanK(long[] a, int n, long k)
    {
        if (k <= 1) {
            return 0;
        }

        long count = 0;
        long prod = 1;

        long start = 0;

        for (long i=0; i<n; i++) {
            prod *= a[(int)i];


            while (start <= i && prod >= k) {
                prod /= a[(int)start];
                start++;
            }

            count += (i - start + 1);
        }


        return count;
    }
}