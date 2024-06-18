package Day9;

import java.util.*;

class CoinsOfGeekLand {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            int[][] a = new int[n][n];

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j] = Integer.parseInt(sc.next());
                }
            }

            int k = Integer.parseInt(sc.next());
            SolutionCOGL T = new SolutionCOGL();
            System.out.println(T.Maximum_Sum(a,n,k));
        }
    }
}

class SolutionCOGL
{
    int removeCol(int r, int c, int k, int[][] arr) {

        int sum = 0;
        for (int i=r; i<r+k; i++) {
            sum -= arr[i][c];
        }

        for (int i=r; i<r+k; i++) {
            sum += arr[i][c+k];
        }

        return sum;

    }

    int removeRow(int r, int k, int[][] arr) {

        int sum = 0;

        for (int i=0; i<k; i++) {
            sum -= arr[r][i];
        }

        for (int i=0; i<k; i++) {
            sum += arr[r+k][i];
        }

        return sum;
    }

    public int Maximum_Sum(int[][] mat, int N, int K){
        int sum = 0;
        for (int i=0; i<K; i++) {
            for (int j=0; j<K; j++) {
                sum += mat[i][j];
            }
        }

        int maxSum = sum;
        int prev = sum;

        for(int i=0; i<N-K; i++) {
            for (int j=0; j<N-K; j++) {
                sum += removeCol(i, j, K, mat);
                maxSum = Math.max(maxSum, sum);
            }

            sum = prev;
            sum += removeRow(i, K, mat);
            maxSum = Math.max(maxSum, sum);
            prev = sum;
        }

        for (int j=0; j<N-K; j++) {
            sum += removeCol(N-K, j, K, mat);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
