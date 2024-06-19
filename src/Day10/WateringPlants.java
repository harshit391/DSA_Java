package Day10;

import java.util.Scanner;

public class WateringPlants {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }

        int capacity = scan.nextInt();

        scan.close();

        System.out.println(new SolutionWP().wateringPlants(arr, capacity));
    }
}

class SolutionWP {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;

        int finalCapacity = capacity;

        for (int i=0; i<plants.length; i++) {

            if (plants[i] <= capacity) {
                steps++;
                capacity -= plants[i];
            } else {
                steps += 2*i + 1;
                capacity = finalCapacity - plants[i];
            }
        }

        return steps;
    }
}
