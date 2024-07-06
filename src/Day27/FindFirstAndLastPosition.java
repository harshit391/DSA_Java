package Day27;

import java.util.Arrays;
import java.util.Scanner;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int target = scan.nextInt();
        System.out.println(Arrays.toString(new SolutionFFALP().searchRange(arr, target)));
    }
}

class SolutionFFALP {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        int[] ans = {-1, -1};
        int found = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                found = mid;
                start = mid + 1;
            }

            else if (nums[mid] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        ans[1] = found;

        start = 0;
        end = nums.length-1;
        found = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                found = mid;
                end = mid - 1;
            }

            else if (nums[mid] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        ans[0] = found;
        return ans;
    }
}