package ThreadTest;
//yield作用是礼让  但是不一定成功  具体调度情况还是看cpu
//join方法  使一个线程运行完再运行其他
public class JoinTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("测试线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest);
        
        thread.start();
        //thread.join();
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();//线程插队
            }

            System.out.println("main" +i );
        }
    }
}
