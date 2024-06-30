package Day21;

import java.io.*;
class LongestPrefixSuffix {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            SolutionLPS ob = new SolutionLPS();
            System.out.println(ob.lps(s));
        }
    }
}

class SolutionLPS {
    boolean check(char[] ch, int i) {
        // System.out.println("This Worked");
        int start = 0;
        int end = ch.length-i-1;

        while (end < ch.length) {
            if (ch[end] != ch[start]) {
                return false;
            }
            start++;
            end++;
        }

        return true;
    }

    int lps(String s) {

        char[] ch = s.toCharArray();

        int ans = 0;
        int n = ch.length;

        char end = ch[n-1];

        for (int i=n-2; i>=0; i--) {
            if (ch[i] == end && ch[n-i-1] == ch[0] && check(ch, i)) {
                ans = i+1;
                break;
            }
        }

        return ans;
    }
}