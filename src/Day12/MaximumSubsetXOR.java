package Day12;


import java.io.*;
class MaximumSubsetXOR
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(s[i]);
            System.out.println(SolutionMSX.maxSubsetXOR(a , n));
        }
    }
}

class SolutionMSX
{
    public static int maxSubsetXOR(int[] arr, int N)
    {
        int index = 0;
        for (int i=31; i>=0; i--) {

            int maxI = index;
            int maxE = Integer.MIN_VALUE;

            for (int j = index; j < N; j++) {

                if ((arr[j] & ( 1 << i)) != 0 && maxE < arr[j]) {
                    maxE = arr[j];
                    maxI = j;
                }
            }

            if (maxE == Integer.MIN_VALUE) {
                continue;
            }

            int temp = arr[index];
            arr[index] = arr[maxI];
            arr[maxI] = temp;

            maxI = index;


            for (int j=0; j<N; j++) {

                if (j != maxI && (arr[j] & (1 << i)) != 0) {
                    arr[j] = arr[j] ^ arr[maxI];
                }
            }

            index++;
        }

        int res = 0;
        for (int i : arr) {
            res ^= i;
        }

        return res;
    }
}