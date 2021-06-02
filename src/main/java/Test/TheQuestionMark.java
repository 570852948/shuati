package Test;

public class TheQuestionMark {
    public static void main(String[] args) {

        boolean b = false && true != true;
        //取余跟除数正负没关系
        int x = -12 % -5;
        System.out.println(b);
        System.out.println(x);
        System.out.println(Math.floorMod(-12,5));
    }
}
