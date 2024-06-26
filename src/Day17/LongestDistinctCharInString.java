package Day17;

import java.io.*;
class LongestDistinctCharInString
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();

            System.out.println(LDC.longestSubstrDistinctChars(S));
        }
    }
}
class LDC {
    static int longestSubstrDistinctChars(String S){

        int start = 0;

        int maxLen = 0;

        int[] freq = new int[26];

        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            freq[curr-'a']++;
            while (start <= i && freq[curr-'a'] > 1) {
                freq[S.charAt(start)-'a']--;
                start++;
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}