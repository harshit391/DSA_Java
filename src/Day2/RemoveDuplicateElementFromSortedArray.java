package Day2;
import java.util.*;

public class RemoveDuplicateElementFromSortedArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int[] a = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();

            SolutionRDEFSA g = new SolutionRDEFSA();
            int n = g.remove_duplicate(a,N);

            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}

class SolutionRDEFSA {
    int remove_duplicate(int[] A, int N){
        int idx = 0;

        int start = 0;

        while (start < N) {
            int end = start + 1;

            while (end < N && A[end] == A[start]) {
                end++;
            }

            if (end < N) {
                A[++idx] = A[end];
            }

            start = end;
        }

        return idx+1;
    }
}