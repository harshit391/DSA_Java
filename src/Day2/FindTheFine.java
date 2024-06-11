package Day2;

import java.util.*;
import java.lang.*;
import java.io.*;


class FindTheFine {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());

            long[] a = new long[(int)(n)];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            long[] b = new long[(int)(n)];
            String[] inputLine1 = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }

            SolutionFindFine obj = new SolutionFindFine();
            System.out.println(obj.totalFine(n, k, a, b));

        }
    }
}


class SolutionFindFine {


    public long totalFine(long n, long date, long[] car, long[] fine) {

        long sum = 0;
        if (date%2 == 0) {

            for (int i=0; i<n; i++) {
                if (car[i]%2!=0) {
                    sum += fine[i];
                }
            }
        } else {
            for (int i=0; i<n; i++) {
                if (car[i]%2==0) {
                    sum += fine[i];
                }
            }
        }

        return sum;

    }
}