package Day14;

import java.util.*;
public class RepeatingNumberNBy3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        scan.close();

        System.out.println(new Solution().majorityElement(arr));
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> set = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;

        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i == c1) {
                count1++;
            }

            else if (i == c2) {
                count2++;
            }

            else if (count1 == 0) {
                c1 = i;
                count1++;
            }

            else if (count2 == 0) {
                c2 = i;
                count2++;
            }

            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i : nums) {
            count1 += (i == c1) ? 1 : 0;
            count2 += (i == c2) ? 1 : 0;
        }

        if (count1 > nums.length/3) {
            set.add(c1);
        }

        if (count2 > nums.length/3) {
            set.add(c2);
        }

        return set;
    }
}