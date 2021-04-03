package collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList list = new java.util.LinkedList();
        //list.add(9);
        list.offer(1);
        list.offer(2);
        list.offer(3);
        String str = "";


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.reverse().toString();
       // System.out.println(list.get(0));
        Iterator iterator = list.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
