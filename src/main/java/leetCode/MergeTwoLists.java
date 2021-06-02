package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表相关
 *
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public  class MergeTwoLists {

    private static ListNode rt;


    public static void main(String[] args) {

        int[] a = {1, 4,2, 3};
        int[] b = {1, 3, 4};
        //ListNode l = createListNode(a);
        //l = l.next;

        System.out.println(max2(a,a.length-1));


        //mergeTwoLists2(createListNode(a),createListNode(b));
        //printListNode(recursion(createListNode(a),createListNode(b)));
    }


    //递归合并两个链表
    //构思方式   直接当做 l1\l2都只有一个节点
    public static ListNode recursion(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //谁小谁在前面
        if (l1.val < l2.val) {
            //l1小  所以l1在前面  待确定l1 下一个是谁
            l1.next = recursion(l1.next, l2);
            return l1;
        }else {
            l2.next = recursion(l1, l2.next);
            return l2;
        }

    }


    //重复练习  递归合并链表
    public ListNode heBing(ListNode a, ListNode b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.val < b.val) {
            a.next = heBing(a.next, b);
            return a;
        }else {
            b.next = heBing(a, b.next);
            return b;
        }
    }






    //递归练习  递归求最大
    public static int max(int[] z, int indexStart, int indexEnd) {

        int max = -1;

        if (indexEnd - indexStart == 1) {
            return z[indexEnd] > z[indexStart] ? z[indexEnd] : z[indexStart];
        }else {

            //max = z[indexEnd] > max(z, indexStart, indexEnd-1) ?z[indexEnd] :max(z, indexStart, indexEnd-1);
            return z[indexEnd] > max(z, indexStart, indexEnd - 1)?z[indexEnd]:max(z, indexStart, indexEnd - 1);
        }


    }
    public static int max2(int[] z, int indexEnd) {

        int max = -1;

        if (indexEnd == 0) {
            return z[indexEnd];
        }else {

            //max = z[indexEnd] > max(z, indexStart, indexEnd-1) ?z[indexEnd] :max(z, indexStart, indexEnd-1);
            return z[indexEnd] > max2(z, indexEnd - 1)?z[indexEnd]:max2(z, indexEnd - 1);
        }


    }

    //遍历链表
    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    //创建链表
    public static ListNode createListNode(int[] z) {
        ListNode R = null;
        ListNode curr = null;
        for (int i = 0; i < z.length; i++) {
            if (i == 0) {
                R = new ListNode(z[i]);
                curr = R;
            }else {
                curr.next = new ListNode(z[i]);
                curr = curr.next;
            }
        }
        return R;
    }


    //错误by自己
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = l1.val > l2.val? l2:l1;
        ListNode curr = result;
        while(l1 != null || l2 != null){
            if(l1 == null){
                result.next = l2;
                break;
            }if(l2 == null){
                result.next = l1;
                break;
            }
//System.out.print(l1.val);
//System.out.println(l2.val);
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
                System.out.println("l2:" + l2.val);
                //System.out.println("z");
            }else{
                //此处会造成指针循环   curr和l1指向同一个节点  这里赋值相当于  l1.next = l1 自己的next指向自己  无线循环
                curr.next = l1;

                l1 = l1.next;
                curr = curr.next;
                System.out.println("l1:" + l1.val);
                //System.out.println(curr.val);
            }



        }
        return result;
    }



    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = null;
        if(l1.val > l2.val){
            result = l2;
            l2 = l2.next;
            if(l2 == null){
                result.next = l1;
                return result;
            }

        }else{
            result = l1;
            l1 = l1.next;
            if(l1 == null){
                result.next = l2;
                return result;
            }
        }

        ListNode curr = result;
        while(l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2;
                break;
            }if(l2 == null){
                curr.next = l1;
                break;
            }
//System.out.print(l1.val);
//System.out.println(l2.val);
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;

                //System.out.println("z");
            }else{
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;

                //System.out.println(curr.val);
            }



        }
        return result;
    }


    /**
     * 判断是否有环
     *
     * 方法一：哈希表
     * 思路及算法
     *
     * 最容易想到的方法是遍历所有节点，每次遍历到一个节点时，
     * 判断该节点此前是否被访问过。
     *
     * 具体地，我们可以使用哈希表来存储所有已经访问过的节点。
     * 每次我们到达一个节点，如果该节点已经存在于哈希表中，
     * 则说明该链表是环形链表，否则就将该节点加入哈希表中。
     * 重复这一过程，直到我们遍历完整个链表即可。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        Set set = new HashSet();

        while (head != null) {

            boolean addResult = set.add(head);
            if (!addResult) {
                return true;
            }
        head = head.next;
        }
        return false;
    }

    /**
     *
     *方法二：快慢指针
     * 思路及算法
     *
     * 本方法需要读者对「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解。
     *
     * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。当「乌龟」和「兔子」从链表上的同一个节点开始移动时，
     * 如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。
     * 等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。
     *
     *
     */
    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }



        ListNode slow = head;
        ListNode fast = head.next;


        while (slow != fast) {
            if (slow == null || slow.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }
}
