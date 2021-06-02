package ThreadTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintABC3 {

    static int count = 0;

    public static void main(String[] args) {

        PrintABC3 printABC3 = new PrintABC3();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("A");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("B");
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C" + " " + count);

            }
        });

        //Executors有点类似arrays
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 15; i++) {
            //count++;  //暂时不清楚为什么主线程来修改这个值  不能及时更新到其它线程
            //System.out.println(count);

            executor.submit(threadA);
            executor.submit(threadB);
            executor.submit(threadC);

        }

        executor.shutdown();
    }

}
