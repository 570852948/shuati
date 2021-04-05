package FunctionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionInterface4 {
    public static void main(String[] args) {

        Supplier supplier = ()->{return "haha";};


        System.out.println(supplier.get());

        List list = new ArrayList();
        list.add("a");
        list.forEach(new Consumer() {
            //forEach去调用accept方法并且把泛型中的个体作为参数传入
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

}
