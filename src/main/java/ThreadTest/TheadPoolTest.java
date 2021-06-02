package ThreadTest;

import java.util.LinkedList;
import java.util.concurrent.*;

public class TheadPoolTest {

    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();//单个线程
        //ExecutorService executorService = Executors.newFixedThreadPool(5);//固定线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();//可伸缩大小
        //阿里巴巴建议用创建ThreadPoolExecutor

        //多线程只能在main函数里用  主线程使用

        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy() );
        try{
            for (int i = 0; i < 9; i++) {
                //使用了线程池之后要使用线程池来创建线程
                //new Thread().start();

                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");

                });
            }
        }finally {
            executorService.shutdown();
        }
    }

}
