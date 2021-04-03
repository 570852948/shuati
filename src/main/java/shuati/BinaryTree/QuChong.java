package shuati.BinaryTree;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class QuChong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){


        int s = scanner.nextInt();
        int[] z = new int[s];
        for(int i=0;i<s;i++){
            z[i] = scanner.nextInt();

        }
            TreeSet(z);
        //int[] g = {6,5,4,3,2,1};//{3,2,2,1,11,10,20,0,32,67,40,20,89,300,400,15};
        //Q2(z);
        //BubbleSort(g);
        }
    }


    static public void TreeSet(int[] f) {
        TreeSet treeSet = new TreeSet();

        for (int r : f) {
            treeSet.add(r);
        }

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    static   public void Q(int[] s){
        for(int i = 0;i<s.length;i++){
            int count = 0;

            for(int j=0;j<s.length;j++){

                if(s[i]==s[j]){
                    count++;
                    if (count>1)
                        s[j]=999999;
                }

            }
        }

        //冒泡排序错误示例
        for (int i = 0; i<s.length;i++){
            for (int j=0;j<s.length;j++){
                if(s[i]<s[j]){
                    int t = s[i];
                    s[i] = s[j];
                    s[j] = t;
                    for (int w:s) {
                        System.out.print(w + " ");
                    }
                    System.out.println();
                }
            }
        }




        for(int a:s){
            if(a != 999999)
                System.out.println(a);
        }
        //for (int i = 0; i<s.length;i++){System.out.println(s[i]);}

    }


    public static void BubbleSort(int[] arr) {
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int a:arr){
            if(a != 999999)
                System.out.println(a);
        }
    }


    static   public void Q2(int[] s){
        for(int i = 0;i<s.length;i++){
            int count = 0;

            for(int j=0;j<s.length;j++){

                if(s[i]==s[j]){
                    count++;
                    if (count>1)
                        s[j]=999999;
                }

            }
        }

        for(int i=0;i<s.length;i++)
            for(int j=0;j<s.length-1;j++){
                if(s[j]>s[j+1]){
                    int t = s[j];
                    s[j] = s[j+1];
                    s[j+1] = t;
                }
            }


        for(int a:s){
            if(a != 999999)
                System.out.println(a);
        }
    }

}
