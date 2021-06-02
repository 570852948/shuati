package shuati;


import java.util.Arrays;

//双指针去重复
public class RemoveDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 4, 4};
        rD(nums);
        int removeDuplicates = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums)+"  index:"+removeDuplicates);
    }

    public static void rD(int[] nums) {

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                //如果两个指针数值不相等  左指针往右移并把右指针的值放进来  碰头就相等了  所以不用考虑
                left++;
                nums[left] = nums[right];

            }else {
                //碰头或者右指针等于左指针数  右指针都往右移动
                right++;
            }

        }
        System.out.println("不重复的个数" + (left+1));
    }


    public static int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=0;
        while(fast<nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

}
