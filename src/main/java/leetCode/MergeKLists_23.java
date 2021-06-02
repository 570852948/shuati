package leetCode;


//Definition for singly-linked list.


import java.util.*;
import java.util.function.Consumer;

public class MergeKLists_23 {

    public static void main(String[] args) {


    }


    /**
     * 队列方法
     *
     * 首先要注意这里的链表与LinkedList的区别
     *
     * 该算法思想
     * 1、先把所有链表（ListNode）按序放进队列  此时有点像二位数组的样子  不过纵向来看是链表  横向是队列
     * 2、把队列中的最小值依次取出来 插入到结果链表中 对于队列中的链表来说需要往后移动一个位置然后再次按序放进队列中
     *    这里需要注意每次放入队列之前需要放的是非空链表，如果null也放到队列中  那么在判断程序结束时就得看队列中是不是全都是null节点
     * 3、当队列为空时程序结束  return 结果链表
     *
     *
     * @param lists
     * @return
     */





    //自己写的   失败
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList();
        ListNode resLNode = new ListNode();
        ListNode l = resLNode;

        for (ListNode listNode : lists) {


            list.add(listNode);



        }
        Collections.sort(list, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                }else return -1;
            }
        });






        for (ListNode listNode : list) {
            if (l == null) {
                l = listNode;
            }else {
                l.next = listNode;
                l = l.next;

            }
        }

        list.clear();

        return null;

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}