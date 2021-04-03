package 继承;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Son extends Father {

    public static void main(String[] args) {

        Son son = new Son();
        try {
            son.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(son.hashCode());


        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase(Locale.ROOT);
        String s = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.print(str.length()-str.replaceAll(s,"").length());


    }

    @Test
    public void reflect() throws NoSuchFieldException, IllegalAccessException {
        Son son = new Son();
        Father father = new Father();
        //子类拥对父类的私有变量具有拥有权 但是不
        //具有使用权。
        son.getClass().getDeclaredField("a");
        Field field = son.getClass().getSuperclass().getDeclaredField("a");
        Field[] field2 = son.getClass().getDeclaredFields();
        for (int i = 0; i < field2.length; i++) {
            System.out.println(field2[i]);
        }
        field.setAccessible(true);
        //field.set(son,5);
        System.out.println(field);

        System.out.println(field.get(son));
    }
}
