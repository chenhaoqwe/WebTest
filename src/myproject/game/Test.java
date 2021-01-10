/**
 * projectName: WebTest
 * fileName: Test.java
 * packageName: myproject.game
 * date: 2021-01-07 17:21
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.game;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Test
 * @packageName: myproject.game
 * @description: test
 * @data: 2021-01-07 17:21
 **/
public class Test {
    public static int count = 0;
    public int i = 0;

    public void changeCount() {
        for (; i < 5; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Test check1 = new Test();
        Test check2 = new Test();
        check1.changeCount();
        check2.changeCount();
        System.out.println(count + ":" + count);
    }
}