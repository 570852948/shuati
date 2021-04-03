package FunctionInterface;

import java.util.function.Consumer;

public class FunctionInterface3 {


    public static void main(String[] args) {

        Consumer<String> consumer = s->{
            System.out.println(s);
        };

        consumer.accept("s");
    }
}
