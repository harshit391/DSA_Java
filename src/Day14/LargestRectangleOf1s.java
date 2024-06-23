package Day14;


import java.util.*;
import java.io.*;

public class LargestRectangleOf1s {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int r = Integer.parseInt(inputLine[0]);
            int c = Integer.parseInt(inputLine[1]);
            boolean[][] mat = new boolean[r][c];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (Integer.parseInt(inputLine[i * c + j]) == 1);
                }
            }

            int ans = new SolutionLR().maxArea(mat, r, c);
            System.out.println(ans);
        }
    }
}

class SolutionLR {

    int giveInt(boolean s) {
        return s ? 1 : 0;
    }

    int maxArea(boolean[][] mat, int r, int c) {


        int[][] arr = new int[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (i == 0) {
                    arr[i][j] = giveInt(mat[i][j]);
                } else {
                    arr[i][j] = !mat[i][j] ? 0 : (arr[i-1][j] + giveInt(mat[i][j]));
                }
            }
        }


        int ans = 0;
        for (int i=0; i<r; i++) {
            Arrays.sort(arr[i]);

            for (int j = 0; j < c / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][c - j - 1];
                arr[i][c - j - 1] = temp;
            }

            for (int j = 0; j < c; j++) {
                int height = arr[i][j];
                int width = j + 1;
                ans = Math.max(ans, height * width);
            }
        }

        return ans;
    }
}