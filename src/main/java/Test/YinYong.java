package Test;

//引用测试
public class YinYong {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = a;

        //StringBuffer stringBuffer = new StringBuffer();
        //stringBuffer.append("a");
        //r(stringBuffer);
        //System.out.println(stringBuffer);
        System.out.println(a==b);
        t(b);
        System.out.println(a==b);

        System.out.println(++a);
    }

    //有点像字符串传参
    public static void t(Integer x){
        x = 2;

    }

    public static void r(StringBuffer stringBuffer){
        stringBuffer.append("b");
    }
}
