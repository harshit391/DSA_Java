package Day1;

import java.io.*;

public class MissingElementsInAp {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new SolutionMissingElement().findMissing(arr, n);
            System.out.println(ans);
        }
    }
}



class SolutionMissingElement {
    int findMissing(int[] arr, int n) {
        int a = arr[0];
        
        int l = arr[n-1];
        
        int d = (l-a)/n;
        
        int start = 0;
        int end = n-1;
        
        while (start <= end) {
           
           int mid = start + (end-start)/2;
           
           int ele = a + mid*d;
           
           if (arr[mid] > ele) {
               end = mid - 1;
           }
           
           else {
               start = mid + 1;
           }
        }
        
        return a + start*d;
    }
}
