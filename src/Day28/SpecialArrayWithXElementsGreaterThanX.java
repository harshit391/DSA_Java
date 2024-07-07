package Day28;
public class SpecialArrayWithXElementsGreaterThanX {
    public static void main(String[] args) {
        System.out.println(new SolutionSAWX().specialArray(new ScannerForArray().giveArr()));
    }
}

class SolutionSAWX {
    int count(int[] nums, int target) {
        int ans = 0;
        for (int i : nums) {
            if (i >= target) {
                ans++;
            }
        }

        return ans;
    }

    public int specialArray(int[] nums) {
        for (int i=0; i<=nums.length; i++) {
            int ans = count(nums, i);

            if (ans == i) {
                return i;
            }
        }

        return -1;
    }
}