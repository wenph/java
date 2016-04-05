package day05.worm;

import javax.swing.JPanel;

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
    }

    public static void main(String[] args){
        System.out.println("haha ");
    }
}
