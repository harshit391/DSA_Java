package Day3;


import java.lang.*;
import java.io.*;

class FrogAndJumps {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {

            String[] inputLine1 = br.readLine().trim().split(" ");
            int i=0;
            int N = Integer.parseInt(inputLine1[i++]);
            int leaves = Integer.parseInt(inputLine1[i++]);

            int[] frogs = new int[(int)(N)];

            String[] inputLine2 = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                frogs[i] = Integer.parseInt(inputLine2[i]);
            }

            SolutionFAJ ob = new SolutionFAJ();
            System.out.println(ob.unvisitedLeaves(N, leaves, frogs));

        }
    }
}

class SolutionFAJ {
    public int unvisitedLeaves(int N, int leaves, int[] frogs) {
        boolean[] vis = new boolean[leaves+1];

        for (int i : frogs) {

            if (i == 1) {
                return 0;
            }

            if (i<N && vis[i]) {
                continue;
            }

            for (int j=i; j<=leaves; j+=i) {
                vis[j] = true;
            }
        }

        int count = 0;
        for (boolean i : vis) {
            if (!i) count++;
        }

        return count-1;
    }
}
