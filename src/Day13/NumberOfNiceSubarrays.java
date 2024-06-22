package Day13;

import java.util.Scanner;

public class NumberOfNiceSubarrays {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int k = scan.nextInt();

        System.out.println(new Solution().numberOfSubarrays(arr, k));
    }
}

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int left = 0, mid = 0, right = 0;

        int count = 0;

        int ans = 0;
        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                count++;
            }

            while (count > k && left < right) {
                if (nums[left]%2 != 0) {
                    count--;
                }
                left++;
            }

            mid = left;

            if (count == k) {

                while (mid < right && nums[mid]%2==0) {
                    mid++;
                }
                ans += mid - left + 1;
            }

            right++;
        }

        return ans;
    }
}