package Day22;

import java.io.*;
class TransformString
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String[] arr = br.readLine().split(" ");
            String A = arr[0];
            String B = arr[1];
            Solution obj = new Solution();
            System.out.println(obj.transform (A, B));
        }
    }
}
class Solution
{
    int transform (String A, String B)
    {

        if (A.length() != B.length()) {
            return -1;
        }

        int[] freq = new int[256];

        for (int i=0; i<A.length(); i++) {
            freq[A.charAt(i)]++;
            freq[B.charAt(i)]--;
        }

        for (int i=0; i<256; i++) {
            if (freq[i] != 0) {
                return -1;
            }
        }

        int i = A.length()-1;
        int j = B.length()-1;

        int res = 0;

        while (i >= 0) {

            if (A.charAt(i) != B.charAt(j)) {
                res++;
            } else {
                j--;
            }

            i--;
        }

        return res;
    }
}