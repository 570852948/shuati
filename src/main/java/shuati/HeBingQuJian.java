package shuati;

import java.util.ArrayList;
import java.util.Collections;

public class HeBingQuJian {
    public static void main(String[] args) {
        ArrayList<Interval> arrayList = new ArrayList<>();
        arrayList.add(new Interval(10,30));
        arrayList.add(new Interval(20,60));
        arrayList.add(new Interval(80,100));
        arrayList.add(new Interval(150,180));

        arrayList = merge(arrayList);
        for (Interval k : arrayList) {
            System.out.println(k.start + " " + k.end);
        }
    }


    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> intervals1 = new ArrayList<>();

        for (Interval i : intervals) {
            for (Interval w : intervals) {

                if (i == w) {
                    continue;
                }
                if (i.start < w.end && i.end >= w.start) {
                    i.end = w.end;
                    intervals1.remove(w);
                    System.out.println(intervals);
                    continue;
                }

                if (i.start < w.start && i.end > w.end){
                    intervals1.remove(w);
                    continue;
                }

            }
        }

        for (Interval q : intervals1) {
            for (Interval a : intervals) {
                if (q.start > a.start) {
                    Interval trmp = q;
                    q = a;
                    a = trmp;
                }

            }
        }


        return intervals1;

    }

    public static class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }


    public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        //排序  没看懂
        Collections.sort(intervals,(a, b)->a.start-b.start);
        int len = intervals.size();
        int i = 0;
        while (i < len) {
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            while (i < len-1 && intervals.get(i+1).start <= right) {
                right = Math.max(right,intervals.get(i+1).end);
                i++;
            }
            res.add(new Interval(left,right));
            i++;
        }
        return res;
    }
}
