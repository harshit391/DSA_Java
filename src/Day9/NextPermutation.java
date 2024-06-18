package Day9;

import java.util.*;

public class NextPermutation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.next());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        scan.close();

        new SolutionNP().nextPermutation(arr);

        System.out.println(Arrays.toString(arr));
    }
}

class SolutionNP {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length-1;

            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int start = i+1;
        int end = nums.length-1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}