package Day18;

import java.io.*;
import java.lang.*;

class SmallestWindowWith012 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            SolutionSWW ob = new SolutionSWW();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
class SolutionSWW {
    public int smallestSubstring(String S) {
        int zero = 0;
        int one = 0;
        int two = 0;


        int minLen = (int)1e9;
        int start = 0;

        for (int i=0; i<S.length(); i++) {

            if (S.charAt(i) == '1') {
                one++;
            } else if (S.charAt(i) == '0') {
                zero++;
            } else {
                two++;
            }

            while (zero > 0 && one > 0 && two > 0) {
                minLen = Math.min(minLen, i - start + 1);
                if (S.charAt(start) == '1') {
                    one--;
                } else if (S.charAt(start) == '0') {
                    zero--;
                } else {
                    two--;
                }
                start++;
            }
        }


        return minLen == 1e9 ? -1 : minLen;
    }
}
