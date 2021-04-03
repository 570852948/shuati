package shuati;

public class BinarySearch {
    static int index = -1;

    public static void main(String[] args) {
        int[] p = {-2};
        search(p, -3);
        System.out.println(index);
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
}
