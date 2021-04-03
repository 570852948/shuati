package shuati;



import java.util.*;

public class HeBingJiHe {

    public static void main(String[] args) {
        int[] list = {1,2,3};
        ListNode h = new ListNode();
        ListNode c = h;
        for (int a :list) {
            c.val = a;
            c.next = new ListNode();
            c = c.next;
        }
        mergeTwoLists(h,h);
    }

    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList();
        ListNode c = l1;
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }
        c = l2;
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }

       // Collection<ListNode> c = l1;
        //list.iterator();
        //Collections是集合的封装工具类  提供排序之类的处理方法
        Collections.sort(list);

        ListNode head = new ListNode();
        c = head;
        for (int a :list) {
            c.val = a;
            c.next = new ListNode();
            c = c.next;
        }

        return head;
    }

    public static class ListNode {
    int val;
    ListNode next = null;
  }

}
