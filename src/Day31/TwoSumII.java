package Day31;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumII {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int target = scan.nextInt();

        System.out.println(Arrays.toString(new Solution().twoSum(arr, target)));
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while (start < end) {

            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[] {start+1, end+1};
            }

            else if (sum > target) {
                end--;
            }

            else {
                start++;
            }
        }

        return new int[] {-1, -1};
    }
}