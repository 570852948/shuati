package leetCode;

import java.util.*;

/**
 * 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案
 */
public class AllPermute_46 {

    static List<List<Integer>> res = new ArrayList();

    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        int[] nums = {1, 2, 3};
        int curr = 0;
        int depth = 0;
        //t(nums);
        backtrack2(nums, deque);
        System.out.println(res);
    }

    //回溯算法
    private static void backtrack(int[] nums, Deque deque, int depth) {
        //出口
        if (depth == nums.length){
            res.add(new ArrayList<>(deque));
            return;
        }


            for (int i = 0; i < nums.length; i++) {
                if (deque.contains(nums[i])) {
                    continue;
                }
                deque.add(nums[i]);
                depth++;
                backtrack(nums, deque, depth);
                deque.removeLast();
                depth--;
            }

    }

    //回溯算法  优化
    private static void backtrack2(int[] nums, Deque deque) {
        //出口
        if (deque.size() == nums.length){
            res.add(new ArrayList<>(deque));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (deque.contains(nums[i])) {
                continue;
            }
            deque.add(nums[i]);

            backtrack2(nums, deque);
            deque.removeLast();//回溯之前需要去掉栈中的最后一个数

        }

    }

    //练习使用  三层for循环查看三个元素所有组合
    public static void t(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {
                    if (nums[i] == nums[k] || nums[k] == nums[j]) {
                        continue;
                    }
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));


                }

            }
        }
    }



}
