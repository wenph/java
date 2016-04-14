package step01.day09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pinghua.wph on 2016/4/14.
 */
public class ServerDemo {
    private ServerSocket socket;
    private int port = 8088;

    public ServerDemo() {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开始服务
     * 等待接收客户端的请求并与其通信
     */
    public void start() {
        System.out.println("等待客户端连接。。。");
        try {
            Socket s = socket.accept();     // 该方法也会阻塞

            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            PrintWriter writer = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String info = reader.readLine();
            System.out.println(info);

            writer.println("你好，客户端！");
            writer.flush();

            info = reader.readLine();
            System.out.println(info);

            writer.println("再见，客户端！");
            writer.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("服务器启动中。。。");
        ServerDemo demo = new ServerDemo();
        demo.start();
    }
}
