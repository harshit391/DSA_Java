package Day30;

import java.util.Arrays;
import java.util.Scanner;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int m = scan.nextInt();

        System.out.println(new Solution().maxDistance(arr, m));
    }
}

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = (position[position.length-1] - position[0])/(m-1);

        int ans = 1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            int j = 1;
            int i = 0;
            int count = 1;
            while (j < position.length) {
                if (position[j] - position[i] >= mid) {
                    count++;
                    i = j;
                }
                j++;
            }

            if (count >= m) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}