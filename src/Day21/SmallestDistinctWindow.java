package Day21;


import java.lang.*;
import java.io.*;

class SmallestDistinctWindow {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();

            SolutionSDW obj = new SolutionSDW();
            System.out.println(obj.findSubString(str));

        }
    }
}
class SolutionSDW {
    public int findSubString( String str) {
        int[] original = new int[128];

        int count = 0;

        for (int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);

            if (original[curr] == 0) {
                count++;
            }

            original[curr]++;
        }

        int newCount = 0;
        int start = 0;

        int len = str.length();

        int[] freq = new int[128];
        for (int i=0; i<str.length(); i++) {

            char curr = str.charAt(i);

            if (freq[curr] == 0) {
                newCount++;
            }

            freq[curr]++;


            while (start <= i && newCount == count) {
                len = Math.min(len, i - start + 1);
                char d = str.charAt(start);
                freq[d]--;
                if (freq[d] == 0) {newCount--;}
                start++;
            }

        }

        return len;
    }
}