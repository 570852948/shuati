package shuati;


import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        //TreeSet具有自动排序功能
        TreeSet<Integer> treeSet = new TreeSet();

        int[] z = {9,8,5,8,1,9,3,4,12};

        for (int q : z) {
            treeSet.add(q);
        }

        for (int w : treeSet) {

            System.out.println(w);

        }
    }
}
