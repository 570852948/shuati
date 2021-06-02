package Test;

public class StaticTestMain {
    public static void main(String[] args) throws ClassNotFoundException {
        //System.out.println(new StaticTest("sdfdsf").s);
        System.out.println();

        //静态加载方法就是new
        //动态加载类  第一种
        Class c = Class.forName("Test.StaticTest");
        System.out.println(c.hashCode());

        //动态加载类  第二种
        ClassLoader classLoader = c.getClassLoader();
        Class s = classLoader.loadClass("Test.StaticTest");
        System.out.println(s.hashCode());
    }

}
