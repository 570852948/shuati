package ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    int count = 0; //打印次数
    Lock lock = new ReentrantLock();  //可重写锁
    Condition conditionA = this.lock.newCondition();
    Condition conditionB = this.lock.newCondition();
    Condition conditionC = this.lock.newCondition();

    public class PrintA implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.print("A");
                    try {
                        conditionB.signal();  //线程b唤醒,因为a打印完应该打印b
                        conditionA.await();  //线程a进入等待队列
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    //System.out.println(Thread.currentThread().getName());
                }
        }
    }

    public class PrintB implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.print("B");
                    try {
                        conditionC.signal();
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    //System.out.println(Thread.currentThread().getName());
                }
        }
    }

    public class PrintC implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.println("C" + count);
                    count++;//打印完c后,count++

                    try {
                        if (count != 15){
                            conditionA.signal();

                        }
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                    //System.out.println(Thread.currentThread().getName()+"c");
                }

        }
    }

    public static void main(String[] args) {
        PrintABC printABCD = new PrintABC();
        new Thread(printABCD.new PrintA()).start();
        new Thread(printABCD.new PrintB()).start();
        new Thread(printABCD.new PrintC()).start();

    }

}
