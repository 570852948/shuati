package shuati;

import java.util.Arrays;

public class BinarySearch {
    static int index = -1;

    public static void main(String[] args) {
        String s = "1,2,3,3";

        String[] split = s.split(",");
        for (String s1 : split) {
            System.out.println(s1);
        }

        int[] p = {-2,2,3,4};
        int target = 3;
//        search(p, -3);
//        System.out.println(index);
        System.out.println(find(p,target));
    }

    public static int search (int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 0)
            return index;
        dg(nums,target,low,high);


        //找第一个target
        if (index != -1) {
            for (int r=0;r<nums.length;r++) {
                if (nums[r] == nums[index]) {
                    index = r;
                    break;
                }
            }
        }

        return index;


    }


    public static void dg(int[] nums, int target,int l,int h) {
        int z =(l+h)/2;
        if (nums[z] == target)
            index = z;
        if (l == h && nums[l] != target) {
            index =-1;
        }



        if (target < nums[z] && l != h) {
            dg(nums, target, l, z-1);
        }
        if (target > nums[z] && l != h) {
            dg(nums, target, z+1, h);
        }

    }


    //二分查找第二遍
    public static int find(int[] nums, int target) {

        Arrays.sort(nums);
        return digui(nums, target, 0, nums.length-1);
    }

    public static int digui(int[] nums, int target, int left, int right) {
        int z = (left + right)/2;
        if (nums[z] == target) {
            return z;
        } else if (left == right) {
            return -1;
        }

        if (nums[z] > target) {
            return digui(nums, target, left, z-1);
        } else return digui(nums, target, z + 1, right);

    }



















}
