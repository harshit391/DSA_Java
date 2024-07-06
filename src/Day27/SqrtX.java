package Day27;

import java.util.Scanner;

public class SqrtX {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        System.out.println(new SolutionSX().mySqrt(n));
    }
}

class SolutionSX {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long start = 0;
        long end = x/2;

        while (start <= end) {
            long mid = start + (end-start)/2;
            if (mid * mid == x) {
                return (int)mid;
            }

            else if (mid * mid < x) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return (int)end;
    }


}