package step01.day05.worm;

import java.util.Arrays;

/**
 * Created by pinghua.wph on 2016/4/5.
 */

/*
 * 贪吃蛇
 */
public class Worm {
    public static final int DEFAULT_LENGTH = 12;        // 蛇的长度
    private Cell[] cells;           // 对象数组，蛇

    public static final int UP = 1;
    public static final int DOWN = -1;
    public static final int LEFT = 2;
    public static final int RIGHT = -2;

    private int currentDirection;   // 蛇当前的运行方向

    public Worm(){                      // 构造方法，初始化“蛇”
        cells = new Cell[DEFAULT_LENGTH];
        for (int i=0;i<cells.length;i++){
            cells[i] = new Cell(i, 0);      // 初始化蛇的位置
        }
        currentDirection = DOWN;
    }

    public boolean contains(int x, int y) {     // 生成的食物是否在蛇身上
        for (int i=0; i<cells.length; i++) {
            Cell node = cells[i];
            if (node.getX()==x && node.getY()==y) {
                return true;
            }
        }
        return false;
    }

    public void creep() {
        for (int i=cells.length-1; i>=1; i--) {             // 蛇爬行，把身体的每个cell往后移一格，然后生成头结点。
            cells[i] = cells[i-1];
        }
        cells[0] = createHead(currentDirection);
    }

    public boolean creep(Cell food) {
        return creep(currentDirection, food);
    }

    public boolean creep(int direction, Cell food) {
        boolean eat = false;        // 吃没吃到？
        if (currentDirection + direction == 0) {
            return false;
        }
        currentDirection = direction;
        Cell head = createHead(direction);
        if (head.getX()==food.getX() && head.getY()==food.getY()) {     // 创建的头结点是否跟食物相同位置，吃到食物。
            eat = true;
        }
        if (eat){
            cells = Arrays.copyOf(cells, cells.length+1);   // 扩容
        }
        for (int i=cells.length-1; i>=1; i--) { // 蛇爬行，把身体的每个cell往后移一格，然后生成头结点。
            cells[i] = cells[i-1];
        }
        cells[0] = head;
        return eat;
    }

    private Cell createHead(int direction) {        // 创建头结点
        int x = cells[0].getX();
        int y = cells[0].getY();
        switch (direction) {
            case DOWN:  y++;break;
            case UP:    y--;break;
            case LEFT:  x--;break;
            case RIGHT: x++;break;
        }
        return new Cell(x, y);
    }

    public boolean hit(int direction) {             // 蛇是否撞到墙或者撞到自己
        Cell head = createHead(direction);
        if (head.getX()<0 || head.getX()>=WormStage.COLS ||
                head.getY()<0 || head.getY()>=WormStage.ROWS) {
            return true;
        }
        for (int i=0; i<cells.length-1; i++) {
            Cell node = cells[i];
            if (node.getX()==head.getX() && node.getY()==head.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean hit() {
        return hit(currentDirection);
    }

    @Override
    public String toString(){
        return Arrays.toString(cells);
    }

    public Cell[] getCells() {
        return Arrays.copyOf(cells, cells.length);
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
