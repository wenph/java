package step01.day09;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by pinghua.wph on 2016/4/14.
 */
public class ClinetDemo {
    private Socket socket;

    public static void main(String[] args) {
        ClinetDemo demo = new ClinetDemo();
        demo.send();
    }

    public void send() {
        try {
            System.out.println("开始连接服务器");
            socket = new Socket("localhost", 8088);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            /**
             * 将输出流变成处理字符串的缓冲字符输出流
             */
            PrintWriter writer = new PrintWriter(out);
            while (true) {
                writer.println("你好，服务器！");
                writer.flush();
                Thread.sleep(500);
            }

//            /**
//             * 将输入流转换为缓冲字符输入流
//             */
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            /**
//             * 读取服务器发送过来的信息，会阻塞
//             */
//            String info = reader.readLine();
//            System.out.println(info);
//
//            writer.println("再见，服务器！");
//            writer.flush();
//
//            info = reader.readLine();
//            System.out.println(info);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
