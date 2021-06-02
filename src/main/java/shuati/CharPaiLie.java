package shuati;

/**
 * 字符全排列
 */
public class CharPaiLie {

    public static void main(String[] args) {
        String s = "abc";
        char[] a = s.toCharArray();
        diGui2(a,0,a.length);


    }


    public static void diGui(char[] a, int start, int end) {


        if (start == end) {
            for (int i = 0; i < end; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }else {

            for (int i = 0; i < end-1; i++) {
                //先交换
                char temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                //进入递归
                diGui(a, start + 1, end);
                //再还原
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

    }


    public static void diGui2(char[] a, int start, int end) {


        if (start == end) {
            for (int i = 0; i < end; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }else {

            for (int i = start; i < end; i++) {
                //交换数组第一个元素和目前游标的位置
                char temp = a[i];
                a[i] = a[start];
                a[start] = temp;
                //进入递归
                diGui2(a, start + 1, end);
                //再还原
                temp = a[i];
                a[i] = a[start];
                a[start] = temp;
            }
        }

    }
}
