package ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//三个线程以此打印ABC 执行15次  失败  尽量不要用这种方法
public class PrintABC1 {

     int k = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition conditionA = this.lock.newCondition();
    Condition conditionB = this.lock.newCondition();
    Condition conditionC = this.lock.newCondition();


    Thread threadA = new Thread(new Runnable() {

        @Override
        public void run() {
            while (k<15){
                lock.lock();
                System.out.print("A");
                try{

                    conditionB.signal();//唤醒B线程
                    conditionA.await();//A线程等待

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }



        }
    });
    Thread threadB = new Thread(new Runnable() {

        @Override
        public void run() {

            while (k < 15) {
                lock.lock();
                System.out.print("B");
                try {

                    conditionC.signal();
                    conditionB.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }

        }
    });
    Thread threadC = new Thread(new Runnable() {

        @Override
        public void run() {



            while (k < 15) {
                lock.lock();
                System.out.println("C" + k);

                k++;
                try {


                    if (k != 15 ){
                        conditionA.signal();

                    }
                    conditionC.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }





            }

        }
    });
    public static void main(String[] args) {


        PrintABC1 abc = new PrintABC1();
        //Lock lock = new ReentrantLock();





        abc.threadA.start();
        abc.threadB.start();
        abc.threadC.start();
    }






}
