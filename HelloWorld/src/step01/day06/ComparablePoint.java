package step01.day06;

/**
 * Created by pinghua.wph on 2016/4/10.
 */

/*
 * 比较
 */
public class ComparablePoint implements Comparable<ComparablePoint> {
    private int x;
    private int y;

    public ComparablePoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(ComparablePoint o) {
        int r = x*x + y*y;
        int other = o.x*o.x + o.y+o.y;
        /*
         * equals返回true的时候，compareTo的返回值应该是0。
         */
        return r - other;
    }
}
