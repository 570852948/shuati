package FunctionInterface;

import java.util.function.Supplier;

public class FunctionInterface4 {
    public static void main(String[] args) {

        Supplier supplier = ()->{return "haha";};


        System.out.println(supplier.get());
    }

}
