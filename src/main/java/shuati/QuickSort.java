package shuati;

import java.util.Arrays;

/**
 * 选择一个基准
 * 分别从左、右开始找一个比基准大和一个比基准小的数
 * 交换位置
 * 如果左右指针相遇 则 将基准数放入该位置
 *
 *
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 55, 6, 11, 9, 5, 1};
        //sort(arr, 0, arr.length - 1);
        //quickS(arr, 0, arr.length - 1);
        quickSort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arrays, int left, int right) {
        //以左边为基准
        int pivot = left;

        //游标
        int l = left;
        int r = right;

        if (left > right) {
            return;
        }

        while (l < r) {

            /**
             * 这里需要注意  如果以左为基准则应该先以右游标向左移动
             * 否则在左右游标交汇时需要和基准游标交换时是在比基准数大的数的位置
             * 交换后不满足基准左边都比左边小
             */
            //找到比基准小的数停下
            while (arrays[r] > arrays[pivot] && l<r) {
                r--;
            }
            //找到比基准大的数停下
            while (arrays[l] <= arrays[pivot] && l<r) {
                l++;
            }

            //如果左右游标汇合就把基准数和当前位置的数交换
            if (l == r) {
                int temp = arrays[l];
                arrays[l] = arrays[pivot];
                arrays[pivot] = temp;
            } else if (l != r) {      //左右游标交换
                int temp = arrays[l];
                arrays[l] = arrays[r];
                arrays[r] = temp;
            }
        }


            sort(arrays,left,l-1);
            sort(arrays, l + 1, right);






    }


    //快速排序第二遍
    public static void quickS(int[] z, int left, int right) {


        int base = left;
        int l = left;
        int r = right;

        if (left > right) {
            return;
        }

        while (left < right) {

            while (z[base] <= z[right] && left<right){
                right--;
            }
            while (z[base] >= z[left] && left<right) {
                left++;
            }

            if (left != right) {
                int temp = z[left];
                z[left] = z[right];
                z[right] = temp;
            }else{
                int temp = z[left];
                z[left] = z[base];
                z[base] = temp;
            }


        }

        //+1  -1与if出口配合
        quickS(z, l, left - 1);
        quickS(z, left + 1, r);
    }


    //快速排序第三遍
    public static void quickSort3(int[] z, int left, int right) {

        int l = left;
        int r = right;
        int pivot = left;

        if (l > r) {
            return;
        }

        while (l < r) {

            while (z[pivot] <= z[r] && l < r) {

                r--;
            }
            while (z[pivot] >= z[l] && l < r) {
                l++;
            }

            if (l != r){
                int t = z[l];
                z[l] = z[r];
                z[r] = t;

            }if (l == r){
                int t = z[l];
                z[l] = z[pivot];
                z[pivot] = t;
            }
        }



        quickSort3(z, left, l - 1);
        quickSort3(z, l + 1, right);


    }






























}
