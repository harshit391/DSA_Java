package Day3;

//{ Driver Code Starts
import java.util.*;

class FindTransitionPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            SolutionTransition obj = new SolutionTransition();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class SolutionTransition {
    int transitionPoint(int[] arr, int n) {

        int start = 0;
        int end = n-1;

        int found = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;

            if (arr[mid] == 1) {
                found = mid;
                end = mid-1;
            }

            if (arr[mid] == 0) {
                start = mid + 1;
            }
        }

        return found;
    }
}