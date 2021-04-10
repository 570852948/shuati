package leetCode;

import javax.rmi.CORBA.Util;
import java.math.BigInteger;
/**
* @Description: leetCode第二题
* @Param: 
* @return: 
* @Author: Mr.Pan
* @Date: 2021/4/10
*/
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);

        ListNode resul = addTwoNumbers4(listNode, listNode1);
        while (resul != null) {
            System.out.println(resul.val);
            resul = resul.next;
        }

//        resul = addTwoNumbers3(new ListNode(0),new ListNode(1));
//        while (resul != null) {
//            System.out.println(resul.val);
//            resul = resul.next;
//        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNodeResult = null;
        ListNode listNodeCurr = null;
        StringBuffer sb = new StringBuffer();
        while (l1 != null) {
            sb.append(l1.val);
            l1 = l1.next;
        }
        BigInteger a = new BigInteger(sb.reverse().toString());
        sb = new StringBuffer();
        while (l2 != null) {
            sb.append(l2.val);
            l2 = l2.next;
        }
        BigInteger b = new BigInteger(sb.reverse().toString());

        BigInteger total = a.add(b);
        String totalString = String.valueOf(total);
        //反转字符串
        totalString = new StringBuffer(totalString).reverse().toString();
        for (int i = 0; i < totalString.length(); i++) {
            if (i == 0) {
                listNodeResult = new ListNode(Integer.valueOf(String.valueOf(totalString.charAt(i))));
                listNodeCurr = listNodeResult;
            }else {
                listNodeCurr.next = new ListNode(Integer.valueOf(String.valueOf(totalString.charAt(i))));
                listNodeCurr = listNodeCurr.next;
            }

        }
        return listNodeResult;
    }

    /**
    * @Description: 不用BigInteger
    * @Param: [l1, l2]
    * @return: leetCode.AddTwoNumbers.ListNode
    * @Author: Mr.Pan
    * @Date: 2021/4/10
    */
    static ListNode listNodeR = null;
    static ListNode listNodeC = null;
    static int flag = 0;
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        //首次进入递归函数
        if (listNodeR == null) {
            listNodeR = new ListNode((l1.val+ l2.val)%10);

            listNodeC = listNodeR;
            if (l1.val + l2.val >= 10)
                flag = 1;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        //三种情况
        if (l1 != null && l2 == null) {
            listNodeC.next = new ListNode((l1.val + flag)%10);

            if (l1.val  + flag >= 10)
                flag = 1;
        } else if (l1 == null && l2 != null) {
            listNodeC.next = new ListNode((l2.val + flag)%10);

            if (l2.val + flag >= 10)
                flag = 1;
        } else if (l1 != null && l2 != null) {
            listNodeC.next = new ListNode((l1.val+ l2.val + flag)%10);

            if (l1.val + l2.val + flag >= 10)
                flag = 1;
        }

        //三种情况
        if (l1 != null && l2 == null) {
            if (l1.val + flag < 10){
                flag = 0;
            }
        } else if (l1 == null && l2 != null) {
            if (l2.val + flag < 10){
                flag = 0;
            }
        } else if (l1 != null && l2 != null) {
            if (l1.val + l2.val + flag < 10){
                flag = 0;
            }
        }



        //无论哪种情况都要走的步骤
        if (l1 != null || l2 != null)
            listNodeC = listNodeC.next;
        if (l1 != null)
            l1 = l1.next;
        if (l2 != null)
            l2 = l2.next;


        if (l1 == null && l2 == null && flag == 1){
            listNodeC.next = new ListNode(1);
        }//else listNodeC = listNodeC.next;

        if (l1 != null || l2 != null)
            addTwoNumbers2(l1, l2);


        //flag = 0;



        return listNodeR;
    }

    /**
    * @Description: 官方思路
    * @Param: [l1, l2]
    * @return: leetCode.AddTwoNumbers.ListNode
    * @Author: Mr.Pan
    * @Date: 2021/4/10
    */
    public static ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curr = null;
        int flag = 0;
        int total = 0;
        int count = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                total = l2.val + flag;
            } else if (l2 == null) {
                total = l1.val + flag;
            } else {
                total = l1.val + l2.val + flag;
            }
            flag = 0;
            if (total >= 10)
                flag = 1;
            if (count == 0) {
                result = new ListNode(total % 10);
                curr = result;
                count++;
            } else {
                curr.next = new ListNode(total % 10);
                curr = curr.next;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            if (l1 == null && l2 == null && flag == 1) {
                curr.next = new ListNode(1);
            }
        }
        return result;
    }






    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode l = addTwoNumbers2(l1, l2);
        listNodeR = null;
        return l;
    }
}
