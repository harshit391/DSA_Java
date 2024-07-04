package Day25;

import java.util.Scanner;

public class CapacityToShipPackages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        int days = scan.nextInt();

        System.out.println(new SolutionCTSP().shipWithinDays(arr, days));
    }
}

class SolutionCTSP {
    public int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;

        for (int i : weights) {

            start = Math.max(start, i);
            end += i;
        }

        int ans = -1;
        while (start <= end) {

            int mid = start + (end-start)/2;

            int pages = 0, count = 1;

            for (int i : weights) {
                pages += i;
                if (pages > mid) {
                    count++;
                    pages = i;
                }
            }

            if (count <= days) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}