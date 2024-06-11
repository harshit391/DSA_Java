package Day2;

import java.util.Scanner;

class SolutionSeachin2d {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;

        int row = matrix[0].length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (matrix[mid][row] == target) {
                return true;
            }

            else if (matrix[mid][row] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        int newStart = 0;
        int newEnd = matrix[0].length-1;

        if (start >= matrix.length) {
            start = matrix.length-1;
        }

        while (newStart <= newEnd) {
            int mid = newStart + (newEnd - newStart)/2;

            if (matrix[start][mid] == target) {
                return true;
            }

            else if (matrix[start][mid] > target) {
                newEnd = mid - 1;
            }

            else {
                newStart = mid + 1;
            }
        }

        return false;
    }
}

class SearchIn2dMatrix{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] matrix = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        int target = scan.nextInt();

        scan.close();

        SolutionSeachin2d obj = new SolutionSeachin2d();

        System.out.println(obj.searchMatrix(matrix, target));

    }
}