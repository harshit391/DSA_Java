package Day25;

import java.io.*;
class PainterPartitionProblem
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input_line1 = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            System.out.println(SolutionPPP.minTime(arr,n,k));
        }
    }
}

class SolutionPPP {

    static long minTime(int[] arr,int n,int k){

        long start = 0;
        long end = 0;

        for (int i : arr) {
            start = Math.max(start, i);
            end += i;
        }

        long ans = Long.MAX_VALUE;

        while (start <= end) {
            long mid = start + (end-start)/2;

            long pages = 0, count = 1;
            for (int i=0; i<n; i++) {
                pages += arr[i];
                if (pages > mid) {
                    count++;
                    pages = arr[i];
                }
            }

            if (count <= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}


