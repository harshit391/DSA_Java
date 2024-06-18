package Day9;

import java.util.Arrays;
import java.util.Scanner;

public class RotateImage {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[][] a = new int[n][n];

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(sc.next());
            }
        }

        new Solution().rotate(a);
        System.out.println(Arrays.deepToString(a));
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
