package Day21;

import java.lang.*;
import java.io.*;

class Solution
{
    public static String caseSort(String str)
    {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lower[ch-'a']++;
            } else {
                upper[ch-'A']++;
            }
        }

        int l = 0;
        int u = 0;

        while (l<26 && lower[l] == 0) {
            l++;
        }

        while (u<26 && upper[u] == 0) {
            u++;
        }

        char[] ans = new char[str.length()];

        for (int i=0; i<str.length(); i++) {

            char curr = str.charAt(i);

            if (curr >= 'a' && curr <= 'z') {

                ans[i] = (char)(l+'a');
                lower[l]--;
                while (l<26 && lower[l] == 0) {
                    l++;
                }
            } else {

                ans[i] = (char)(u+'A');
                upper[u]--;
                while (u<26 && upper[u] == 0) {
                    u++;
                }
            }


        }

        return new String(ans);
    }
}

class CaseSpecificSorting {
    public static void main (String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            String[] words = br.readLine().split("\\s+");
            int numTestCases = Integer.parseInt(words[0]);

            for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
                words = br.readLine().split("\\s+");
                int size = Integer.parseInt(words[0]);
                String str = br.readLine();
                String sortedStr = Solution.caseSort(str);
                out.println(sortedStr);
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}