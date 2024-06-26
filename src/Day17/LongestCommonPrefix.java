package Day17;

import java.io.*;
class LongestCommonPrefix
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String[] arr = read.readLine().trim().split(" ");

            SolutionLCP ob = new SolutionLCP();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}

class SolutionLCP {
    String longestCommonPrefix(String[] arr, int n){

        int minLen = arr[0].length();
        int idx = 0;

        for (int i=1; i<n; i++) {
            int curr = arr[i].length();
            if (curr < minLen) {
                minLen = curr;
                idx = i;
            }
        }

        int ans = minLen;
        for (int i=0; i<n; i++) {
            int curr = 0;
            for (int j=0; j<minLen; j++) {
                if (arr[i].charAt(j) == arr[idx].charAt(j)) {
                    curr++;
                } else {
                    break;
                }
            }

            ans = Math.min(curr, ans);
        }

        String a = arr[idx].substring(0, ans);

        return a.isEmpty() ? "-1" : a;
    }
}