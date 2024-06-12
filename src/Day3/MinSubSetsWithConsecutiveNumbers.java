package Day3;


import java.util.*;
import java.lang.*;
import java.io.*;

class MinSubSetsWithConsecutiveNumbers {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(SolutionMSW.numofsubset(a, n));

        }
    }
}


// } Driver Code Ends


//User function Template for Java


class SolutionMSW {

    public static int numofsubset(int[] arr, int n)
    {
        Arrays.sort(arr);

        int count = 0;
        int i = 0;

        while (i < n) {

            int j = i+1;
            int k = i;

            while (j < n && arr[j] == arr[k]+1) {
                j++;
                k++;
            }

            count++;
            i = j;
        }

        return count;
    }
}