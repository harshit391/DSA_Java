package Day3;

import java.util.*;
import java.lang.*;
import java.io.*;

class FindIndexesOfASubArray{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{

        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            String[] s = br.readLine().trim().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] a = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            ArrayList<Integer> res = Solution.subarraySum(a, n, k);
            for (Integer re : res)
                ot.print(re + " ");
            ot.println();
        }
        ot.close();
    }

}

class Solution
{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {

        int start = 0;
        int end = 0;

        ArrayList<Integer> res = new ArrayList<>();

        int sum = 0;
        while (end < n) {
            sum += arr[end];

            while (start < end && sum > s) {
                sum -= arr[start];
                start++;
            }

            if (sum == s) {
                res.add(start+1);
                res.add(end+1);
                return res;
            }

            end++;
        }

        res.add(-1);
        return res;
    }
}
