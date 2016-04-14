import step01.day05.worm.Cell;
import step01.day05.worm.Worm;
import step01.day05.worm.WormStage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by pinghua.wph on 2016/4/5.
 */
public class TestCase {
    @Test
    public void testWormInit(){
        System.out.println("测试Worm构造器");
        Worm worm = new Worm();
        System.out.println(worm);
        assertEquals(2, 1+1);
    }

    @Test
    public void testWormStage() {
        System.out.println("创建舞台实例");
        WormStage wormStage = new WormStage();
        System.out.println(wormStage);
    }

    @Test
    public void testCreep() {
        System.out.println("爬行测试");
        Worm worm = new Worm();
        System.out.println(worm);
        worm.creep();
        System.out.println(worm);
    }

    @Test
    public void testCreepForFood() {
        System.out.println("检查食物的爬行");
        Worm worm = new Worm();
        Cell food = new Cell(1,2);
        System.out.println(worm);
        System.out.println(worm.creep(Worm.DOWN, food));
        System.out.println(worm);
        System.out.println(worm.creep(Worm.DOWN, food));
        System.out.println(worm);
        System.out.println(worm.creep(Worm.RIGHT, food));
        System.out.println(worm);
    }

    @Test
    public void testHit() {
        System.out.println("碰撞测试");
        Worm worm = new Worm();
        Cell food = new Cell(10,10);
        System.out.println(worm);
        System.out.println(worm.creep(Worm.DOWN, food));
        System.out.println(worm);
        System.out.println(worm.creep(Worm.DOWN, food));
        System.out.println(worm);
        System.out.println(worm.hit(Worm.LEFT));        // true
        System.out.println(worm.hit(Worm.RIGHT));       // false
        System.out.println(worm.creep(Worm.RIGHT, food));
        System.out.println(worm);
        System.out.println(worm.creep(Worm.RIGHT, food));
        System.out.println(worm);
        System.out.println(worm.creep(Worm.UP, food));
        System.out.println(worm);
        System.out.println(worm.hit(Worm.UP));        // true
    }
}
