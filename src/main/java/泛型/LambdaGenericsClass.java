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
         *     之所以List<String>表示里面装着很多String
         *
         * 官方：操作的数据类型被指定为一个参数
         *
         *
         *
         * //? super T Consumer<这里只能为A或A的父类>   因为只有这样在accept里才能执行他的或者父类的方法(因为继承的关系）
         */
        list.forEach(new Consumer<A>() {
            @Override
            public void accept(A b) {
                System.out.println(b.a());

            }
        });


        /**
         *                       理解误区  容易把action和<? super T> 建立联系  实际上二者没有联系<>里的东西是需要我们来自己定义的
         *     default void forEach(Consumer<? super T> action) {
         *         Objects.requireNonNull(action);
         *         for (T t : this) {
         *             action.accept(t);
         *         }
         *     }
         */

        //list.forEach(a-> System.out.println(a.a()));
    }
}
