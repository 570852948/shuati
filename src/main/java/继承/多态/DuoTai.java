package 继承.多态;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DuoTai {

    public static void a(List list) {
        System.out.println("list");
    }

    public static void a(Collection collection) {
        System.out.println("collection");
    }


    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("sss");
        a(list);

    }
}
