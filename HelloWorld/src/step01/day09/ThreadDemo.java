package step01.day09;

/**
 * Created by pinghua.wph on 2016/4/14.
 */

/**
 * 多线程并发安全问题
 *
 * synchronized关键字
 * 线程安全锁
 * synchronized可以修饰方法也可以单独作为语句块存在
 * synchronized的作用是限制多线程并发时同时访问该作用域
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Thread t1 = bank.new Person();
        Thread t2 = bank.new Person();

        t1.start();
        t2.start();
        /**
         * t1和t2都在bank对象上等待了，进入阻塞
         */
        bank.count = 1000;
        Thread.sleep(500);
        synchronized (bank) {
            bank.notifyAll();
//            bank.notify();
        }
    }
}


class Bank{
    int count = 1000;

    /**
     * 取钱方法
     * synchronized修饰后，会给方法上锁，变异步为同步了。
     *
     * synchronized同步块
     * synchronized(Object) {
     *     需要同步的代码片段
     * }
     * 这里必须注意！Object要确保所有线程看到的是同一个对象，否则起不到同步效果。
     */
    synchronized void getMoney(int money) {
        if (count == 0) {
            throw new RuntimeException("余额为0");
        }
        Thread.yield();
        count -= money;
    }

//    void getMoney(int money) {
//        synchronized (this) {         // 效率高
//            if (count == 0) {
//                throw new RuntimeException("余额为0");
//            }
//        }
//        Thread.yield();
//        count -= money;
//    }

    class Person extends Thread {
        @Override
        public void run() {
            System.out.println("准备取钱，等待银行开门！");
            try {
                synchronized (Bank.this) {
                    Bank.this.wait();       // 当前线程（Person）在银行对象上等待
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                getMoney(100);
                System.out.println("当前余额：" + count);
                Thread.yield();
            }
        }
    }
}