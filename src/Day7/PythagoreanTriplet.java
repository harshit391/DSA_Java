package Day7;


import java.io.*;

public class PythagoreanTriplet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

class Solution {
    boolean checkTriplet(int[] arr, int n) {

        int maxE = 0;
        for (int i : arr) {
            maxE = Math.max(maxE, i);
        }

        int[] hash = new int[maxE+1];

        for (int i : arr) {
            hash[i]++;
        }

        for (int i=1; i<=maxE; i++) {

            if (hash[i] == 0) {
                continue;
            }

            for (int j=1; j<=maxE; j++) {

                if ((i == j && hash[i] == 1) || hash[j] == 0) {
                    continue;
                }

                int val = (int)Math.sqrt(i*i + j*j);

                if ((val * val) != (i*i + j*j)) {
                    continue;
                }

                if (val > maxE) {
                    continue;
                }


                if (hash[val] >= 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
