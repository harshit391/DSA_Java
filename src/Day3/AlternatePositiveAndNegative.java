package Day3;


import java.io.*;

public class AlternatePositiveAndNegative {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new SolutionAlternate().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

class SolutionAlternate {
    void rearrange(int[] arr, int n) {
        int[] pos = new int[n];
        int[] neg = new int[n];

        int i = 0;
        int j = 0;

        for (int k : arr) {
            if (k >= 0) {
                pos[i++] = k;
            } else {
                neg[j++] = k;
            }
        }

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        while (idx1 < i && idx2 < j) {
            arr[idx3++] = pos[idx1++];
            arr[idx3++] = neg[idx2++];
        }

        while (idx1 < i) {
            arr[idx3++] = pos[idx1++];
        }

        while (idx2 < j) {
            arr[idx3++] = neg[idx2++];
        }
    }
}