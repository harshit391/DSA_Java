package Day6;
import java.io.*;

public class RowWith1s {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new SolutionRW1().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

class SolutionRW1 {

    int rowWithMax1s(int[][] arr, int n, int m) {


        int min = m;
        int ans = -1;
        for (int i=0; i<m; i++) {
            if (arr[0][i] == 1) {
                min = i;
                ans = 0;
                break;
            }
        }

        if (min == 0) {
            return 0;
        }

        for (int i=1; i<n; i++) {
            int j = min-1;
            while (j>=0 && arr[i][j] == 1) {
                j--;
            }
            if (j < min-1) {
                min = j+1;
                ans = i;
            }
        }

        return ans;

    }
}

