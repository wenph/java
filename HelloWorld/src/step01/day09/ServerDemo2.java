package step01.day09;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.Timer;

/**
 * Created by pinghua.wph on 2016/4/14.
 */

/**
 * 服务器端
 * 支持线程池
 *
 * 加入双缓冲队列，加快读写数据操作
 *
 */
public class ServerDemo2 {
    private ServerSocket socket;
    private int port = 8088;
    // 线程池
    private ExecutorService threadPool;
    // 双缓冲队列
    private BlockingQueue<String> msgQueue;

    public ServerDemo2() {
        try {
            socket = new ServerSocket(port);
            // 创建50个线程固定大小的线程池
            threadPool = Executors.newFixedThreadPool(50);
            // 创建规定大小的双缓冲队列
            msgQueue = new LinkedBlockingQueue<String>(10000);
            /**
             * 创建定时器，周期性的将队列中的数据写入文件
             */
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true));
                        String msg = null;
                        for (int i = 0; i < msgQueue.size(); i++) {
                            msg = msgQueue.poll(0, TimeUnit.MILLISECONDS);
                            if (msg == null) {
                                break;
                            }
                            writer.println(msg);
                        }
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开始服务
     * 等待接收客户端的请求并与其通信
     */
    public void start() {
        try {
            while (true) {
                System.out.println("等待客户端连接。。。");
                Socket s = socket.accept();     // 该方法也会阻塞
                System.out.println("一个客户端过来了，分配线程接待他");
//                Thread clientThread = new Thread(new Handler(s));
//                clientThread.start();
                /**
                 * 将线程体（并发的任务）交给线程池
                 * 线程池会自动将该任务分配给一个空闲线程去执行。
                 */
                threadPool.execute(new Handler(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 定义线程体，该线程的作用是与连接到服务器的客户端进行交互操作
     */
    class Handler implements Runnable{
        private Socket socket;      // 当前线程要进行通信的客户端socket
        public Handler(Socket socket) {     // 通过构造方法将客户端的socket传入
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String info = null;
                while (true) {
                    // 循环读取客户端发过来的信息
                    info = reader.readLine();
                    if (info != null) {
                        /**
                         * 插入成功返回true
                         * 该方法会阻塞线程，若中断会报错！
                         */
                        boolean b = msgQueue.offer(info, 5, TimeUnit.SECONDS);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("服务器启动中。。。");
        ServerDemo2 demo = new ServerDemo2();
        demo.start();
    }
}
