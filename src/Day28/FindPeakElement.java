package Day28;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(new SolutionFPE().findPeakElement(new ScannerForArray().giveArr()));
    }
}

class SolutionFPE {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;


        while (start <= end) {
            int mid = start + (end-start)/2;

            if (mid-1 >= 0 && mid + 1 < nums.length && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
                return mid;
            }

            else if (mid-1 >= 0 && nums[mid] < nums[mid-1]) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return end;

    }
}