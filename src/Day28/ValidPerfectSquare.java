package Day28;
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new SolutionVPS().isPerfectSquare(new ScannerForArray().giveNumber()));
    }
}

class SolutionVPS {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }

        long start = 2;
        long end = num;

        while (start <= end) {
            long mid = start + (end-start)/2;

            if (mid * mid == num) {
                return true;
            }

            else if (mid * mid > num) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return false;
    }
}