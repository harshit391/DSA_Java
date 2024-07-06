package Day27;

import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int target = scan.nextInt();
        System.out.println(new SolutionSIP().searchInsert(arr, target));
    }
}

class SolutionSIP {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return start;
    }
}