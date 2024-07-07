package Day28;

import java.util.Scanner;

class ScannerForArray {

    Scanner scan = new Scanner(System.in);

    int[] giveArr() {
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        return arr;
    }

    int giveNumber() {
        return scan.nextInt();
    }
}
