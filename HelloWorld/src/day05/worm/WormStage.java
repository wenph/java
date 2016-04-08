package day05.worm;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

/**
 * Created by pinghua.wph on 2016/4/5.
 */

/*
 * 面板
 */
public class WormStage extends JPanel {         // 继承JPanel面板
    public static final int ROWS = 35;          //行数
    public static final int COLS = 35;          //列数
    public static final int CELL_SIZE = 10;    //格子像素大小：10个像素

    private Worm worm;
    private Cell food;

    public WormStage(){
        worm = new Worm();
        food = createFood();
    }
    /*
     * 生成一个随机数x，y，检查蛇是否包含这个点，如果包含继续生成
     */
    private Cell createFood() {
        int x;      // 列
        int y;      // 行
        Random r = new Random();
        do {
            x = r.nextInt(COLS);
            y = r.nextInt(ROWS);
        }while (worm.contains(x, y));

        return new Cell(x, y);
    }

    @Override
    public String toString() {
        return "worm:" + worm + ",food:" + food;
    }

    @Override           // 重写标示符，最好写上，这样如果该方法是不可以重写的或者该方法在的重写是错误的，能及时发现错误。
    public void paint(Graphics g){
        //背景
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), getHeight());
        //food
        g.setColor(Color.red);
        g.fill3DRect(CELL_SIZE * food.getX(), CELL_SIZE * food.getY(), CELL_SIZE, CELL_SIZE, true);
        //snake
        g.setColor(Color.green);
        Cell[] cells = worm.getCells();
        for(int i=0;i<cells.length; i++){
            Cell node = cells[i];
            g.fill3DRect(CELL_SIZE*node.getX(), CELL_SIZE*node.getY(), CELL_SIZE, CELL_SIZE, true);
        }
    }

    public void action(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (worm.hit()) {
                    worm = new Worm();
                    food = createFood();
                } else {
                    boolean eat = worm.creep(food);
                    if (eat) {
                        food = createFood();
                    }
                }
                repaint();
            }
        }, 0, 1000 / 5);

        this.requestFocus();            // 获取焦点
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key){
                    case KeyEvent.VK_UP:
                        creepTo(Worm.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        creepTo(Worm.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        creepTo(Worm.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        creepTo(Worm.RIGHT);
                        break;
                }
            }
        });
    }

    private void creepTo(int direction) {
        if (direction==Worm.UP || direction==Worm.DOWN){
            if (worm.getCurrentDirection()==Worm.UP || worm.getCurrentDirection()==Worm.DOWN) {
                return;
            }
        }
        if (direction==Worm.LEFT || direction==Worm.RIGHT){
            if (worm.getCurrentDirection()==Worm.LEFT || worm.getCurrentDirection()==Worm.RIGHT) {
                return;
            }
        }
        if(worm.hit(direction)){
            worm = new Worm();
            food = createFood();
        }else{
            boolean eat = worm.creep(direction, food);
            if(eat){
                food = createFood();
            }
        }
        repaint();
    }


    public static void main(String[] args){
        JFrame frame = new JFrame("SnakeGame");
        frame.setLayout(null); // 取消自动充满
        frame.setSize(450, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WormStage panel = new WormStage();
        panel.setSize(CELL_SIZE * COLS, CELL_SIZE * ROWS);
        panel.setLocation(50, 50);
        panel.setBorder(new LineBorder(Color.black));
        frame.add(panel);
        panel.action();
    }
}
