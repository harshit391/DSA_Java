package Day24;

import java.io.*;
class Complete{
    int KthMissingElement(int[] a, int n, int k)
    {
        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (a[mid] - mid - a[0] >= k) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }



        int diff = k - (a[end] - end - a[0]);
        if (a[end] + diff > a[n-1]) {
            return -1;
        }

        return a[end] + diff;
    }


}

class KthMissingPositive {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){

            String line1 = br.readLine();
            String[] element = line1.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int[] arr = new int[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");

            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }

            Complete obj = new Complete();

            int res = obj.KthMissingElement(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}
