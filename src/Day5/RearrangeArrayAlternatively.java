package Day5;

import java.lang.*;
import java.io.*;

class RearrangeArrayAlternatively {
    public static void main (String[] args)throws IOException
    {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- >0)
        {

            int n = Integer.parseInt(read.readLine());
            long[] arr= new long[n];

            String str[] = read.readLine().trim().split(" ");


            for(int i=0;i<n;i++)
                arr[i] = Long.parseLong(str[i]);


            Solution.rearrange(arr, n);
            StringBuffer sb = new StringBuffer();


            for(int i =0; i < n; i++)
                sb.append(arr[i]).append(" ");
            System.out.println(sb);
        }
    }
}


class Solution{

    public static void rearrange(long arr[], int n){

        long ele = arr[n-1] + 1;

        int maxI = n-1;
        int minI = 0;

        for (int i=0; i<n; i++) {

            if (i%2 == 0) {
                arr[i] += (arr[maxI] % ele) * ele;
                maxI--;
            }

            else {
                arr[i] += (arr[minI] % ele) * ele;
                minI++;
            }
        }

        for (int i=0; i<n; i++) {
            arr[i] /= ele;
        }

    }

}


