package FunctionInterface;

import java.util.function.Predicate;

/**
* @Description: 段定型接口：有一个输入参数，返回值只能是布尔值
* @Param: 
* @return: 
* @Author: Mr.Pan
* @Date: 2021/3/30
*/
public class FunctionInterface2 {

    public static void main(String[] args) {
        Predicate<String> predicate = str->{return true;};

        System.out.println(predicate.test("6"));

    }
}
