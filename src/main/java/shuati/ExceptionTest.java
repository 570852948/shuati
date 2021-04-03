package shuati;


import org.junit.Test;

public class ExceptionTest {

    @Test
    public void t() throws Exception {

        try {
            System.out.println(1 / 0);

        } catch (Exception e) {
            throw new Exception("异常");//System.out.println("发现异常")
        }
    }

    @Test
    public void c() {

        try {
            new ExceptionTest().t();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
