package Day10;

import java.io.*;
import java.util.*;

class CountPrimesInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            SolutionCP ob = new SolutionCP();
            System.out.println(ob.countPrimes(L, R));
        }
    }
}

class SolutionCP {
    int countPrimes(int L, int R) {

        if (L <= 1) {
            L = 2;
        }

        boolean[] primes = new boolean[R+1];

        Arrays.fill(primes, true);

        for (int i=2; i*i<=R; i++) {

            if (primes[i]) {

                for (int j=i*i; j<=R; j+=i) {

                    primes[j] = false;
                }
            }
        }

        int count = 0;

        for (int i=L; i<=R; i++) {
            if (primes[i]) count++;
        }

        return count;
    }
}
