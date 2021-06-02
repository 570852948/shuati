package Test;

public class StaticTest {
    public static final StaticTest st;
    String s;

    public StaticTest() {

    }

    public StaticTest(String s) {
        this.s = s;
    }

    static {
        st = new StaticTest("静态块初始化");
        System.out.println("是的发送到发");
    }

    static void staticMethod() {
        System.out.println("我是静态方法");
    }


    public static void main(String[] args) {
        //System.out.println(new StaticTest("sdfdsf").s);
        //System.out.println(StaticTest.st.s);
    }
}


