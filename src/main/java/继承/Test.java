package 继承;

import java.lang.reflect.Field;

class ReflectionTest{
    private String str="csdn";
    public void print(){
        System.out.println(str);
    }
}
//------------------------------------


public class Test{
    int a = 555;
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
        ReflectionTest t=new ReflectionTest();
        t.print();
        Field[] f=t.getClass().getDeclaredFields();

        for(int i=0;i<f.length;i++)
        {
            f[i].setAccessible(true);
//System.out.println(f[i].getType());
            f[i].set(t, "japan");
        }
        t.print();
    }
}