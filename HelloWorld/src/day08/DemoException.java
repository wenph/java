package day08;

/**
 * Created by pinghua.wph on 2016/4/13.
 */

/**
 * java的异常Exception分为：
 * 运行时异常：编译时不检查异常，RuntimeException及其子类：空指针异常、
 * 可检查异常：编译时检测：ParseException、越界异常
 */
public class DemoException {
    public static void main(String[] args) {
        System.out.println(
                test(null) + "," + test("0") + "," + test("abc")    // 4,4,4
        );
    }

    public static int test(String str) {
        try {
            return str.charAt(0) - '0';
        }catch (NullPointerException e){
            return 1;
        }catch (RuntimeException e){
            return 2;
        }catch (Exception e){
            return 3;
        }finally {
            return 4;
        }
    }
}
