package leetCode;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }



    public static int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        int r = 0;
        if (x < 0) {
            sb.append(x*-1);
            try {
                r = Integer.valueOf("-" + sb.reverse().toString());
            } catch (Exception e) {
                return 0;
            }
            return r;
        }else {
            sb.append(x);

            try {
                r = Integer.valueOf(sb.reverse().toString());
            } catch (Exception e) {
                return 0;
            }

            return r;
        }
    }
}
