package step01.day09;

/**
 * Created by pinghua.wph on 2016/4/14.
 */
public class DemoInnerClass {
    private int age;

    public static void main(String[] args) {
        DemoInnerClass obj = new DemoInnerClass();
        obj.sayAge();

        Inner inner = obj.new Inner();
        inner.sayAge();
    }

    public void sayAge() {
        System.out.println("外部类："+age);
    }

    class Inner {
        public void sayAge() {
            /**
             * OuterClassName.this 表示外部类的对象
             * DemoInnerClass.this就表示当前Inner所处外部类的对象
             */
            DemoInnerClass.this.sayAge();
            System.out.println("内部类："+age);
        }
    }
}
