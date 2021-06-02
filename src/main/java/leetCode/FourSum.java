package leetCode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中
 * 是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 答案中不可以包含重复的四元组。
 */
public class FourSum {

    public static void main2(String[] args) {
        List list1 = Arrays.asList(1, 2, 3);//发现asList函数返回的ArrayList不是一个东西
        List list2 = Arrays.asList(1, 2, 3);
        System.out.println(list1.hashCode() == list2.hashCode());
        Set set = new HashSet();
        System.out.println(list1);


        List list3 = new ArrayList();
        List list4 = new ArrayList();
        list3.add(1);
        list3.add(2);
        list4.add(1);
        list4.add(2);
        System.out.println(list3.hashCode() == list4.hashCode());

        set.add(list1);
        set.add(list2);
        System.out.println(set);

    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arr,0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set set = new HashSet();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    while (nums[i] + nums[j] + nums[l] + nums[r] < target && l < r) {
                        l++;
                    }
                    while (nums[i] + nums[j] + nums[l] + nums[r] > target && l < r) {
                        r--;
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target && l < r){

                        set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
