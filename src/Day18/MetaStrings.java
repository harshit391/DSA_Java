package Day18;

import java.io.*;
class MetaStrings{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();
            SolutionMS obj = new SolutionMS();
            if(obj.metaStrings(S1, S2))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}

class SolutionMS
{
    boolean metaStrings(String S1, String S2)
    {
        if (S1.compareTo(S2) == 0) {
            return false;
        }

        if (S1.length() != S2.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i=0; i<S1.length(); i++) {
            freq[S1.charAt(i)-'a']++;
        }

        for(int i=0; i<S2.length(); i++) {
            freq[S2.charAt(i)-'a']--;
        }

        for (int i=0; i<26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        int changes = 0;
        for (int i=0; i<S1.length(); i++) {
            if (S1.charAt(i) != S2.charAt(i)) {
                changes++;
            }
        }

        return changes == 2;
    }
}


