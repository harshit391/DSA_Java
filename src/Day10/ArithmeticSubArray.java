package Day10;

import java.util.*;

public class ArithmeticSubArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int ln = scan.nextInt();
        int[] left = new int[ln];
        for (int i=0; i<ln; i++) {
            left[i] = scan.nextInt();
        }

        int rn = scan.nextInt();
        int[] right = new int[ln];
        for (int i=0; i<rn; i++) {
            right[i] = scan.nextInt();
        }

        System.out.println(new SolutionAS().checkArithmeticSubarrays(arr, left, right));
    }
}

class SolutionAS {
    public boolean checkArt(int[] arr) {
        int n = arr.length;
        if (n <= 2) {
            return true;
        }

        for (int i=0; i<n-2; i++) {
            if (arr[i+1] - arr[i] != arr[i+2] - arr[i+1]) {
                return false;
            }
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans = new ArrayList<>();

        for (int i=0; i<l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            int k = 0;
            for (int j=l[i]; j<=r[i]; j++) {
                arr[k++] = nums[j];
            }
            Arrays.sort(arr);
            ans.add(checkArt(arr));
        }

        return ans;
    }
}
