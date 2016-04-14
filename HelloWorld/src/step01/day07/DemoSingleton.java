package step01.day07;

/**
 * Created by admin on 16/4/12.
 */

/**
 * 设计模式
 * 创建型模式：单例模式、工厂模式等
 * 结构型模式：装饰模式、代理模式等
 * 行为型模式：模板方法模式、迭代器模式等
 */
public class DemoSingleton {
    /**
     * 单例模式：限量版，就一个！
     *
     * 私有化构造方法，外界就不能new了，通过静态方法获取实例，静态方法里必须是静态变量，所以obj要设置为静态的；
     */

    private static DemoSingleton obj;

    private DemoSingleton() {

    }

    public static DemoSingleton getInstance() {
        if (obj == null) {
            obj = new DemoSingleton();
        }
        return obj;
    }
}
