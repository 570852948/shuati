package shuati;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxLength {
    public static void main(String[] args) {
        int[] arr = {2,3,2,5};
        System.out.println(maxLength2(arr));
        //System.out.println(arr.length);
    }

    //错误  需要的是连续不重复的
    public static int maxLength(int[] arr) {
        List<Integer> list = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }

        return list.size();
    }


    public static int maxLength2 (int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0,max = 0;
        for(int i = 0;i < arr.length;i++){
            int curr = arr[i];
            start = Math.max(start,map.get(curr)==null?0:map.get(curr));
            max = Math.max(max,i - start + 1);
            map.put(curr,i+1);
        }
        return max;



    }
    @Test
    public void t(){

        int a = 0;
        System.out.println(a == 1?0:"haha");


    }


    public static int maxLength3(int[] arr) {
        List<Integer> list = new ArrayList();
        int start = 0;
        for (int i = start; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }else {
                start = 1;
            }
        }

        return list.size();
    }

}
