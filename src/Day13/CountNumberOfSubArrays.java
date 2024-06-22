package Day13;

import java.io.*;
class CountNumberOfSubArrays{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){
            String[] input_line = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            long L = Long.parseLong(input_line[1]);
            long R = Long.parseLong(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            int[] A = new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            SolutionCNSA ob = new SolutionCNSA();
            long ans = ob.countSubarray(N, A, L, R);
            System.out.println(ans);
        }
    }
}

class SolutionCNSA
{
    long subCount(int N, int[] A, long R) {
        long count = 0;
        long sum = 0;

        int start = 0;
        int end = 0;

        while (end < N) {
            sum += A[end];

            while (sum > R && start <= end) {
                sum -= A[start];
                start++;
            }

            count += (end-start+1);

            end++;
        }

        return count;
    }
    long countSubarray(int N, int[] A, long L, long R) {
        return subCount(N, A, R) - subCount(N, A, (L-1));
    }
}
