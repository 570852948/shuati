package ThreadTest;

//lock锁测试
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//发现问题  测试线程时尽量不要用@Test
public class TestLock {
    static int a = 10;
    int b = 10;
    public void ain(String[] args) {
        TestLock testLock = new TestLock();

        ReentrantLock lock = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

            new Thread(new Runnable() {



                @Override
                public void run() {
                    while (true) {
                        try {

                            lock.lock();

                            if (testLock.b > 0) {


                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("a");
                                System.out.println(testLock.b--);
                            } else {

                                break;
                            }
                        }finally {
                            lock.unlock();
                        }
                    }

                }
            }).start();



        new Thread(new Runnable() {



            @Override
            public void run() {
                while (true) {
                    try {

                        lock.lock();

                        if (testLock.b > 0) {


                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("b");
                            System.out.println(testLock.b--);
                        } else {

                            break;
                        }
                    }finally {
                        lock.unlock();
                    }
                }

            }
        }).start();



        new Thread(new Runnable() {



            @Override
            public void run() {
                while (true) {
                    try {

                        lock.lock();

                        if (testLock.b > 0) {


                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("c");
                            System.out.println(testLock.b--);
                        } else {

                            break;
                        }
                    }finally {
                        lock.unlock();
                    }
                }

            }
        }).start();


        new Thread(new Runnable() {



            @Override
            public void run() {
                while (true) {
                    try {

                        lock.lock();

                        if (testLock.b > 0) {


                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("d");
                            System.out.println(testLock.b--);
                        } else {

                            break;
                        }
                    }finally {
                        lock.unlock();
                    }
                }

            }
        }).start();

}


   // @Test
    public static void main(String[] args) {
//        TestThread testThread1 = new TestThread();
//        TestThread testThread2 = new TestThread();
//        TestThread testThread3 = new TestThread();
        TestRunnable testRunnable = new TestRunnable();
        Thread testThread1 = new Thread(testRunnable);
        Thread testThread2 = new Thread(testRunnable);
        Thread testThread3 = new Thread(testRunnable);
        testThread1.start();
        testThread2.start();
        testThread3.start();

    }


}

class TestThread extends Thread{
    Lock lock = new ReentrantLock();
    private int b = 10;
    @Override
    public void run() {

        while (true) {
            try {

                lock.lock();

                if (b > 0) {

                    System.out.println("ss");
                    System.out.println(this.getName());
                    System.out.println(b--);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else {

                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

class TestRunnable implements Runnable{
    Lock lock = new ReentrantLock();
    int b = 10;

//    @Override
//    public void run() {
//        while (true) {
//            if (b>0){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(b--);
//            }else break;
//        }
//    }


        @Override
    public void run() {
        while (true) {
            try {
                System.out.println(lock);
                lock.lock();

                if (b > 0) {


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("a");
                    System.out.println(b--);
                } else {
                    System.out.println("daoz");
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
