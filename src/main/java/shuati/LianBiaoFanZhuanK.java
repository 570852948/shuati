package shuati;

public class LianBiaoFanZhuanK {


    public static void main(String[] args) {

    }

    public Boolean judge(ListNode current,int k) {
        for (int i = 0; i < k; i++) {
            if (current.next != null)
                current = current.next;
            else return false;
        }
        return true;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultHead = head;
        ListNode current = head;
        ListNode pre = null;
        if (judge(current,k)){

            for (int j = 0; j < k; j++) {
                current.next = pre;
                pre = current;
                if (j < k-2){
                    current = head.next;
                    head = head.next;
                    current = current.next;
                }else {
                    current.next = null;
                }

            }


        }
        return resultHead;
    }

}


class ListNode {
    int val;
    ListNode next = null;
}