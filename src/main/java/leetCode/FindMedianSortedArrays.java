package leetCode;


import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        //float d = 0.1f / 0.2f;
        //System.out.println();
        int[] a = {1,2};
        int[] b = {3,4};
        //mergeArray(a,3,b,3);
        int[] result = mergeArray2(a,b);

        //System.out.println(a[1]);
        //inputParameter(a);
        //System.out.println(a[1]);
        //merge2(a,3,b,3);
        //System.out.println(a.length);
        //System.out.println(findMedianSortedArrays(a,b));
        double z = findMedianSortedArrays2(a, b);
        System.out.println(z);
    }

    public static void inputParameter(int[] param) {
        param[1] = 100;
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double result = 0;
        int[] merge = mergeArray2(nums1, nums2);
        int y = merge.length % 2;
        if (y == 0) {
            result = (merge[merge.length/2 - 1] + merge[merge.length/2])/2.0 ;
            return result;
        }

        return merge[merge.length/2];
    }

    //合并有序数组自己2
    public static int[] mergeArray2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0) {
            return nums2;
        } else if (length2 == 0) {
            return nums1;
        }

        int[] result = new int[length1 + length2];

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < result.length; i++) {

            //判断两个数组中的游标指向的元素大小  小的放进新数组并且index+1
            if (index1 != length1 && index2 != length2)
                result[i] = nums1[index1] > nums2[index2] ? nums2[index2++] : nums1[index1++];
            //只要有一个index到达尾端就把另一个数组放进去
            if (index1 == length1) {
                for (int j = index2; j < length2; j++) {
                    result[++i] = nums2[j];
                }
                return result;
            }if (index2 == length2){
                for (int j = index1; j < length1; j++) {
                    result[++i] = nums1[j];
                }
                return result;
            }
        }
        return result;
    }




    //合并有序数组自己
    public static void mergeArray(int[] nums1,int m, int[] nums2,int n) {
        int[] temp = new int[m+n];
        int index1 = 0;
        int index2 = 0;

        if (nums2.length == 0) {
            return;
        }

        while(index1+index2!=m+n){

            if(nums1[index1]<nums2[index2] && index1<m){
                temp[index1+index2] = nums1[index1];
                index1++;
            }else if(nums1[index1]>=nums2[index2] && index2<n){
                temp[index1+index2] = nums2[index2];
                index2++;
            }

            if(index1 == m && index2 != n){
                while(index1+index2!=m+n){
                    temp[index1+index2] = nums2[index2];
                    index2++;
                }
            }

            if(index1 != m && index2 == n){
                while(index1+index2!=m+n){
                    temp[index1+index2] = nums1[index1];
                    index1++;
                }
            }

        }

        int i = m+n-1;
        //nums1 = temp;
        while(i>=0) {
            nums1[i] = temp[i];
            System.out.println(temp[i]);
            System.out.print(nums1[i]);
            i--;

        }
    }



    //别人
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //确定新数组长度
        int i = m--+--n;

        while(n>=0) {
            //由后往前确定新数组中每一个元素的位置
            nums1[i--] = m>=0 && nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];

        }
    }

    //常规思路过于复杂
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;


        if (nums1.length == 0 && nums2.length != 0) {
            if (nums2.length % 2 != 0) {
                return nums2[nums2.length/2];
            }
            return (nums2[nums2.length/2]+nums2[nums2.length/2 + 1])/2.0;
        }

        if (nums1.length != 0 && nums2.length == 0) {
            if (nums1.length % 2 != 0) {
                return nums1[nums1.length/2];
            }
            return (nums1[nums1.length/2]+nums2[nums1.length/2 + 1])/2.0;
        }


        List l = insert(nums1, nums2);
        return result;
    }


    public static List insert(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        List list = new ArrayList();

        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if ((int)list.get(j) <= nums2[i] && (int)list.get(j + 1) > nums2[i]) {
                    list.add(j+1,nums2[i]);
                    break;
                    //i++;
                }
                if (i == 0 && (int) list.get(j) > nums2[i]) {
                    list.add(0,nums2[i]);
                    break;
                }
            }
        }
        return list;
    }
}
