import java.util.Arrays;

public class Test {

    static void swap(long[] nums, int a, int b)
    {
        long temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    static void arrange(long[] nums, int n)
    {
        int i = 0;

        while (i<n)
        {
            long correct = nums[i];

            if (nums[i] < nums.length && nums[i]!=nums[(int)correct])
                swap(nums, i, (int)correct);
            else i++;
        }
    }

    public static void main(String[] args) {
//        long[] arr = new long[5];
//
//        arr[0] = 4;
//        arr[1] = 0;
//        arr[2] = 2;
//        arr[3] = 1;
//        arr[4] = 3;
//
//        arrange(arr, arr.length);
//
//        System.out.println(Arrays.toString(arr));

        int[] arr  = {1, 2, 3, 4};


        System.out.println(Arrays.toString(arr));
    }


}
