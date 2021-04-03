package shuati;



import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
* 链表反转
*
* */
public class Solution {
    static ListNode listNode = null;
    static ListNode pos = null;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            if (a == 0)
                break;
            Add(a, pos);



        }
        pos = listNode;
        //pos = ReverseList(pos);
        pos = FanZhuan(pos);

        while (pos != null) {

            System.out.println(pos.val);

            pos = pos.next;
            if (pos ==null )
                break;
        }
    }

    //新建链表
     public static void Add(int a,ListNode pos2) {

        if (pos2 == null) {
            pos2 = new ListNode(a);
            System.out.println(pos2.val+ "  " + pos2);
            //头结点
            listNode = pos2;
            pos = pos2;

        }else {
            pos2.next = new ListNode(a);
            pos2 = pos2.next;
            System.out.println(pos2.val+ "  " + pos2);
            pos = pos2;
        }

    }




    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FanZhuan(ListNode Head) {
        ListNode pre = null;
        ListNode pos = null;

        //有个技巧等号XXX=可以看做外部指向箭头  XXX.next可以看做内部穿线指向箭头
        while (Head != null){
            pos = Head;
            Head = Head.next;
            pos.next = pre;
            pre = pos;
        }


        return pos;
    }




    public static ListNode ReverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while( head != null){
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre; // 让当前节点指向前一个节点位置，完成反转
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }


    public static Boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            if (list.contains(head))
                return true;
            list.add(head);
            head = head.next;



        }
        return false;
    }
    public class TreeNode {
       int val = 0;
       TreeNode left = null;
       TreeNode right = null;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }
 }

    @Test
    public void Test() {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.left.right.left = new TreeNode(5);
        treeNode.right.left = new TreeNode(4);
        ArrayList<ArrayList<Integer>> list = levelOrderByPl(treeNode);
        for (ArrayList<Integer> a : list) {
            for (Integer i : a) {
                System.out.println(i);
            }
        }

    }

        public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
            // write code here
            if(root == null){
                return new ArrayList<>();
            }


            LinkedList<TreeNode> queue = new LinkedList<>();
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list;
            queue.offer(root);

            while(!queue.isEmpty()){

                list = new ArrayList<>();
                //检索队列中的最后一个元素
                TreeNode tail = queue.peekLast();
                System.out.println(tail.val);
                while(true){
                    //检索并删除队列中的第一个元素
                    TreeNode cur = queue.poll();
                    list.add(cur.val);
                    //如果左孩子不为空，则把左孩子放到队列中
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    //如果右孩子不为空，则把右孩子放到队列中
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                    //
                    if(cur == tail){

                        System.out.println("跳出循环");
                        break;
                    }
                }

                lists.add(list);
            }


            return lists;


        }

    public static ArrayList<ArrayList<Integer>> levelOrderByPl (TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();


        LinkedList<TreeNode> duilie = new LinkedList();
        TreeNode curr = null;
        if (root == null)
            return null;
        duilie.add(root);
        //最后一个元素
        TreeNode lastEvery = root;
        while (!duilie.isEmpty()) {
            //每一层的list
            ArrayList arrayList = new ArrayList();
            lastEvery = duilie.getLast();
            while (curr != lastEvery) {

                //取出第一个进入队列的元素，并删除
                curr = duilie.poll();
                if (curr.left != null) {
                    duilie.offer(curr.left);
                }
                if (curr.right != null) {
                    duilie.offer(curr.right);
                }


                arrayList.add(curr.val);

            }
            arrayLists.add(arrayList);
        }
        return arrayLists;


    }


}
