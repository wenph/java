import day05.worm.Worm;
import org.junit.Test;

/**
 * Created by pinghua.wph on 2016/4/5.
 */
public class TestCase {
    @Test
    public void testWormInit(){
        System.out.println("测试Worm构造器");
        Worm worm = new Worm();
        System.out.println(worm);
    }
}
