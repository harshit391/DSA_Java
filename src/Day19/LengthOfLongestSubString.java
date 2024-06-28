package Day19;

import java.io.*;

class LengthOfLongestSubString
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
class Solution{
    int longestUniqueSubsttr(String S){
        int[] freq = new int[26];

        int start = 0;

        int maxLen = 0;

        for (int i=0; i<S.length(); i++) {
            char curr = S.charAt(i);

            freq[curr-'a']++;

            while (start<=i && freq[curr-'a'] > 1) {
                freq[S.charAt(start)-'a']--;
                start++;
            }

            maxLen = Math.max(i-start+1, maxLen);
        }

        return maxLen;
    }


}