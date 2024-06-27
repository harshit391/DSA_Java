package Day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveDuplicatesFromString {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}
class Solution {
    String removeDuplicates(String str) {
        int[] freq = new int[128];

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            freq[curr]++;
            if (freq[curr] == 1) {
                sb.append(curr);
            }
        }

        return sb.toString();
    }
}

