package jvm;

public class VM {

    public static void main(String[] args) {
        //jvm试图使用的最大内存
        long l = Runtime.getRuntime().maxMemory();

        //jvm初始化内存
        long l2 = Runtime.getRuntime().totalMemory();

        System.out.println("max:"+l/1024/1024+"MB\t"+"total:"+l2/1024/1024+"MB");
    }
}
