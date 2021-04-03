package jvm;

public class OOM {
    //OutOfMemory  -Xms5m -Xmx5m -XX:+PrintGCDetails
    public static void main(String[] args) {
        String str = "sadsdasdfasdfsa";
        while (true) {
            str += str;
        }
    }
}
