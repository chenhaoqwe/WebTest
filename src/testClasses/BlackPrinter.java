/**
 * projectName: WebTest
 * fileName: BlackPrinter.java
 * packageName: testClasses
 * date: 2020-12-31 14:49
 * copyright(c) 2017-2020 xxx公司
 */
package testClasses;

/**
 * @version: V1.0
 * @author: LZY
 * @className: BlackPrinter
 * @packageName: testClasses
 * @description:
 * @data: 2020-12-31 14:49
 **/
public class BlackPrinter implements Ink {
    @Override
    public void print() {
        System.out.println("黑白打印");
    }
}