package day05.worm;

import java.util.AbstractCollection;
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

    public Worm(){                      // 构造方法，初始化“蛇”
        cells = new Cell[DEFAULT_LENGTH];
        for (int i=0;i<cells.length;i++){
            cells[i] = new Cell(i, 0);      // 初始化蛇的位置
        }
    }

    public String toString(){
        return Arrays.toString(cells);
    }
}
