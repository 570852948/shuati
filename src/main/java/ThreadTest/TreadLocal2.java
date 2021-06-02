package ThreadTest;

//使用ThreadLocal绑定变量content
public class TreadLocal2 {
    static class Demo {
        //String content;

        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        public String getContent() {
            return threadLocal.get();
        }

        public void setContent(String content) {
            threadLocal.set(content);
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    /**
                     * 之所以不同 是因为多个线程都同时操作demo对象的content变量
                     * a线程set以后  被b线程set并取出  a线程又get
                     */
                    demo.setContent(Thread.currentThread().getName()+"的数据");

                    System.out.println("-------------------------------------------------------------");
                    System.out.println(Thread.currentThread().getName() + "----->" + demo.getContent());

                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}