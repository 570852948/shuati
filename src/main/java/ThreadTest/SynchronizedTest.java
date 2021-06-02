package ThreadTest;



/**
* @Description: Synchronized(object)  之所以需要object  是因为是根据实例object来确定调用的代码块是一组存在同步关系的两个代码块  以此锁住该代码块
* @Param:
* @return:
* @Author: Mr.Pan
* @Date: 2021/4/20
*/
public class SynchronizedTest {

    public static void main(String[] args) {

        SynchronizedTest synchronizedTest = new SynchronizedTest();


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

//                synchronized (synchronizedTest) {
                    System.out.println("开始线程1");
                try {
                    synchronizedTest.l();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


//                }

                System.out.println("被唤醒");

            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public  void run() {

//                synchronized (synchronizedTest) {
                    System.out.println("开始线程2");
                    synchronizedTest.l2();

//                }

            }

        });

        thread1.start();
        thread2.start();
    }


    //方法上的synchronized锁住的是所属对象  多个线程调用多个方法要能够通信  必须使调用的多个方法锁住同一个实例对象  这样才知道该去唤醒哪些线程  换句话说  锁住同一个对象的线程才是归为一组的
    public synchronized void l() throws InterruptedException {
        System.out.println("我是锁住的方法1");
        System.out.println("开始等待");
        wait();
        System.out.println("我又启动了");
    }

    public synchronized void l2() {
        System.out.println("我是锁住的方法2");
        notify();
    }



}
