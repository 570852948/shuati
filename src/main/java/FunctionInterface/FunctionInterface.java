package FunctionInterface;

import java.util.function.Function;

/**
* @Description: 函数型接口
* @Param:
* @return:
* @Author: Mr.Pan
* @Date: 2021/3/30
*/
public class FunctionInterface {
    public static void main(String[] args) {

        //工具类
        Function function = new Function<String,String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };

        Function function2 = (str)->{return str;};
        Function function3 = str->{return str;};
        System.out.println(function2.apply("sss"));
    }

}
