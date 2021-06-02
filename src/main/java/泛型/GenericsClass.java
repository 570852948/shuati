package 泛型;

import java.util.List;

/**
 * 泛型类的定义
 * @param <T>泛型标识  --  类型形参
 *           T 创建对象的时候指定具体的数据类型
 */
public class GenericsClass<T> {


    //T是由外部使用类的时候来指定的
    private T key;

    public GenericsClass(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "GenericsClass{" +
                "key=" + key +
                '}';
    }


    public static void main(String[] args) {
        GenericsClass<String> stringGenericsClass = new GenericsClass<String>("ss");
        String key = stringGenericsClass.getKey();
        System.out.println(key);
    }
}
