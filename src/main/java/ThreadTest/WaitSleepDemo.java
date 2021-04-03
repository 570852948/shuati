package ThreadTest;
/*
* Thread.sleep  只会让出CPU不会释放资源锁
    Object.wait 还会让出资源锁
*
*
* */
public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        final Object lock2 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {

                /*
                * synchronized理解：
                * 运行synchronized()代码块时会把括号里的资源占用
                * 以此作为多个线程判断是否能运行synchronized()代码块的依据
                * Object.wait时会把占用的资源释放，此时其他线程就可以占用该资源并且运行synchronized代码块
                *
                * */
                synchronized (lock) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("a线程");
                    }
//                    try {
//                        System.out.println("A get lock");
//                        Thread.sleep(20);
//                        System.out.println("A do wait method");
//                        lock.wait(2000);
//                        System.out.println("A is done");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }



                }



            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock) {

//                    try {
//                        System.out.println("B get lock");
//                        lock.notify();
//                        System.out.println("B do sleeping method");
//
//                        lock.wait(10);
//
//
//                        System.out.println("B is done");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    for (int i = 0; i < 100; i++) {
                        System.out.println("b");
                    }


                }



            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("回到主线程");
    }


}
