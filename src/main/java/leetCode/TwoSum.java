package leetCode;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,2,4};
        int[] ints = twoSum.twoSum(nums, 6);
        for (int i : ints) {
            System.out.println(i);
        }
    }


    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int difference_value = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (difference_value == nums[j]) {
                    int[] a = {i, j};
                    return a;
                }

            }
        } return null;
    }
}
