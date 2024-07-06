package Day27;

import java.io.*;
class CubeRootOfANumber {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            System.out.println(SolutionCRON.cubeRoot(N));
        }
    }
}

class SolutionCRON {
    static int cubeRoot(int N) {
        if (N <= 1) {
            return N;
        }

        long start = 0;
        long end = N-1;

        while (start <= end) {
            long mid = start + (end-start)/2;

            long val = mid * mid * mid;

            if (val == N) {
                return (int)mid;
            }

            else if (val > N) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return (int)end;
    }
}