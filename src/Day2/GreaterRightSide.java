package Day2;

import java.util.*;
import java.io.*;

public class GreaterRightSide {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new SolutionGRS().nextGreatest(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

class SolutionGRS {
    void nextGreatest(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i=n-1; i>=0; i--) {
            if (st.empty() || st.peek() <= arr[i]) {
                st.add(arr[i]);
            }
        }

        for (int i=0; i<n; i++) {
            if (arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.empty()) {
                arr[i] = -1;
            } else {
                arr[i] = st.peek();
            }
        }

    }
}