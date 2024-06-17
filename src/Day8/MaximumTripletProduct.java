package Day8;


import java.io.*;


class SolutionMTP {
    Long maxTripletProduct(Long[] arr, int n)
    {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        long firstMin = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;

        for (long i : arr) {

            if (i > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            }

            else if (i > secondMax) {
                thirdMax = secondMax;
                secondMax = i;
            }

            else if (i > thirdMax) {
                thirdMax = i;
            }

            if (i < firstMin) {
                secondMin = firstMin;
                firstMin = i;
            }

            else if (i < secondMin) {
                secondMin = i;
            }
        }

        return Math.max(firstMax*secondMax*thirdMax, firstMax*firstMin*secondMin);
    }
}

class MaximumTripletProduct {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){

            int sizeOfArray = Integer.parseInt(br.readLine());

            Long[] arr = new Long[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");

            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Long.parseLong(elements[i]);
            }

            SolutionMTP obj = new SolutionMTP();
            Long res = obj.maxTripletProduct(arr, sizeOfArray);
            System.out.println(res);
        }
    }
}
