package Day18;


import java.lang.*;
import java.io.*;
class MinNumberOfFlips
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            SolutionMNOF ob = new SolutionMNOF();

            System.out.println(ob.minFlips(S));

        }
    }
}

class SolutionMNOF {
    public int minFlips(String S) {
        int change0 = 0;
        int change1 = 0;

        if (S.charAt(0) == '0') {
            change1 = 1;
        } else {
            change0 = 1;
        }

        for (int i=1; i<S.length(); i++) {
            if (i%2 == 0) {
                if (S.charAt(i) == '0') {
                    change1++;
                } else {
                    change0++;
                }
            } else {
                if (S.charAt(i) == '0') {
                    change0++;
                } else {
                    change1++;
                }
            }
        }

        return Math.min(change0, change1);
    }
}