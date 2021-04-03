package ThreadTest;

public class WaitAndNotify {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        //保证两个线程run的方法都在一个实例对象下  而且该方法都被synchronized所声明
        new Prouductor(synContainer).start();
        new Consumer(synContainer).start();
    }

}

//生产者
class Prouductor extends Thread{
    SynContainer synContainer;

    public Prouductor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    //生产

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            synContainer.push(new Chicken(i));
            System.out.println("生产了第" + (i+1) + "只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println("消费了第" +(synContainer.pop().id+1) + "只鸡");
        }
    }
}
//食物
class Chicken extends Thread{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    //synchronized在方法上时代表运行该方法 保证一段代码只能有一个线程在运行，保证线程的同步。
    /*
    * wait/notify/notifyAll需要放在synchronized声明的方法或者代码块
    * 切换的线程对应的两个方法都要在一个实例对象里
    * */
    public synchronized void push(Chicken chicken) {
        if (count == chickens.length) {
            try {
                //生产线程等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("daozh");
        chickens[count] = chicken;
        count++;
        this.notifyAll();

    }

    public synchronized Chicken pop() {
        if (count == 0) {

            try {
                //消费线程等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        count--;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }
}

