package day08;

import sun.awt.windows.ThemeReader;

/**
 * Created by pinghua.wph on 2016/4/13.
 */
public class TestInnerClass {
    public static void main(String[] args) {
        /**
         * 匿名类实现继承Thread形式
         */
        Thread t1 = new Thread(){
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(i);
                }
            }
        };

        /**
         * 匿名类实现，实现Runnable接口的形式
         */
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("hello " + i + " count");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
