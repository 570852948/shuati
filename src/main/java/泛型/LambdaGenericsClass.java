package 泛型;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 */
public class LambdaGenericsClass {

    static class A{
        String a() {
            return "a";
        }
    }
    static class B extends A{
        String a() {
            return "b";
        }
    }

    static class C extends B {
        String a() {
            return "c";
        }
    }


    public static void main(String[] args) {
        List<B> list = new ArrayList();

        list.add(new C());


        /**
         * Consumer<A> 代表该类中的T全部替换为A
         *
         * 要注意与List<String>区分  理解一直有误  <String>代表的是<T>全换成String类型  而不是任何有<String>的就是，里面就装着很多<String>
         *
         * 官方：操作的数据类型被指定为一个参数
         */
        list.forEach(new Consumer<A>() {
            @Override
            public void accept(A b) {
                System.out.println(b.a());

            }
        });

        //list.forEach(a-> System.out.println(a.a()));
    }
}
