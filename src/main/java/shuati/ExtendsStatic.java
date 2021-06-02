package shuati;

import java.util.*;

public class ExtendsStatic {
    public static void main(String[] args) {
        Collection<?>[] collections ={new HashSet<String>(), new ArrayList<String>(), new HashMap<String, String>().values()};

        //对于静态方法  声明是父类就调用父类的方法
        Super subToSuper = new Sub();
        //Collection<?>表示调用getType(Collection<?> collection)方法
        for (Collection<?> collection : collections) {
//            if (collection.getClass() == HashSet.class) {
//                System.out.println(subToSuper.getType((HashSet)collection));
//            }
            System.out.println(Super.getType(collection));

        }


    }

    abstract static class Super {

        //静态方法
        public static String getType(Collection<?> collection) {
            return "Super:collection";
        }

        public static String getType(List<?> list) {
            return "Super:list";
        }

        public String getType(ArrayList<?> list) {
            return "Super:arrayList";
        }

        public static String getType(Set<?> set) {
            return "Super:set";
        }

        public String getType(HashSet<?> set) {
            return "Super:hashSet";
        }
    }

    static class Sub extends Super {
        public static String getType(Collection<?> collection) {
            return "Sub";
        }
    }
}