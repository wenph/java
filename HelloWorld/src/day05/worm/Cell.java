package day05.worm;

/**
 * Created by pinghua.wph on 2016/4/5.
 */

/*
 *  一个单元格
 */
public class Cell {
    private int x;
    private int y;

    public Cell(){}                 // 无参构造方法

    public Cell(int x, int y){      // 有参构造方法
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "[" + x + "," + y + "]";
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
