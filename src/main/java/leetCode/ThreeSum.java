package leetCode;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 *
 *
 *
 *
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};




        //List<List<Integer>> list = threeSum(nums);
        //list.forEach((e)-> e.forEach(System.out::println));
        //System.out.println(- nums[5]);
        //System.out.println(threeSumViolence(nums));
        System.out.println(threeSumTrue(nums));
    }

    //暴力解法  三层for循环
    public static List<List<Integer>> threeSumViolence(int[] nums) {
        List o = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        //res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        List temp = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp);
                        String str = temp.toString();
                        //去重
                        if (!o.contains(str)){
                            o.add(str);
                            res.add(temp);
                        }
                    }
                }
            }
        }
        return res;
    }


    //排序+双指针
    public static List<List<Integer>> threeSumTrue(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        HashSet set = new HashSet();
        Arrays.sort(nums);

        //确定target  另外两数之和相加等于target
        for (int i = 0; i < nums.length - 2; i++) {

            int target = -nums[i];

            int l = i + 1;
            int r = nums.length - 1;


            while (l < r) {

                //两数之和小于目标值  左指针向右移动  不能移动超过了右指针
                while (nums[l] + nums[r] < target && l < r) {

                    l++;

                }
                //两数之和大于目标值  右指针向左移动  不能超过左指针
                while (nums[l] + nums[r] > target && l < r) {

                    r--;

                }
                //找到两个和为target的数  并且确定是两个数字
                if (nums[l] + nums[r] == target && l != r) {


                    //把找到的几个数字放进hashSet
                    set.add(Arrays.asList(nums[i],nums[l], nums[r]));
                    //指针继续移动  因为可能出现多组和都等于target的情况
                    l++;

                }
            }

        }


        lists = new ArrayList<>(set);
        return lists;
    }

    //自己的方案  一开始把数组分为三块区域然后组合找和为0的
    // 不行
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        int group = length / 3;
        List temp = new ArrayList();
        int[] t = new int[3];

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < group; i++) {
            for (int j = group; j < 2 * group; j++) {
                for (int k = 2 * group; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> integers = new ArrayList<>();

                        t[0] = nums[i];
                        t[1] = nums[j];
                        t[2] = nums[k];
                        Arrays.sort(t);
                        String ts = t[0] + t[1] + t[2] + "";
                        if (!temp.contains(ts)){
                            integers.add(nums[i]);
                            integers.add(nums[j]);
                            integers.add(nums[k]);
                            list.add(integers);
                            temp.add(ts);
                        }



                    }
                }
            }
        }
        return list;

    }
}
