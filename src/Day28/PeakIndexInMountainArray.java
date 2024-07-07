package Day28;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(new SolutionPIIMA().peakIndexInMountainArray(new ScannerForArray().giveArr()));
    }
}

class SolutionPIIMA {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (mid-1 >= 0 && mid+1 < arr.length && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }

            else if (mid+1 < arr.length && arr[mid] < arr[mid+1]) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}