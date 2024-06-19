package Day10;

import java.util.Arrays;
import java.util.Scanner;

public class CountPrimes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        System.out.println(new Solution().countPrimes(n));
    }
}

class Solution {
    public int countPrimes(int n) {

        boolean[] primes = new boolean[n];

        Arrays.fill(primes, true);

        for (int i=2; i*i<n; i++) {

            if (primes[i]) {

                for (int j=i*i; j<n; j+=i) {

                    primes[j] = false;
                }
            }
        }

        int count = 0;

        for (int i=2; i<n; i++) {
            if (primes[i]) count++;
        }

        return count;
    }
}