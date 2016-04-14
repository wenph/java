package step01.day08;

/**
 * Created by pinghua.wph on 2016/4/13.
 */
public class TestInterruptedException {
    public static void main(String[] args) {
        /**
         * 林 进入睡眠状态
         *
         * 方法中定义的类叫做局部内部类
         * 局部内部类中若想引用当前方法的其他局部变量，那么该变量必须是final的。
         */
        final Thread lin = new Thread(){
            @Override
            public void run() {
                System.out.println("林：睡觉了。。。");
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("林：干嘛呢！干嘛呢！");
                    System.out.println("林：都破了相了！");
                }
            }
        };

        Thread huang = new Thread(){
            @Override
            public void run() {
                System.out.println("黄：80一锤子，您说砸哪儿？");
                for (int i = 0; i < 5; i++) {
                    System.out.println("黄：80！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("咣当！");
                System.out.println("黄：搞定！");
                lin.interrupt();        // 中断第一个线程的阻塞状态
            }
        };

        lin.start();
        huang.start();
    }
}
