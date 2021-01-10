/**
 * projectName: WebTest
 * fileName: ColorPrinter.java
 * packageName: testClasses
 * date: 2020-12-31 14:49
 * copyright(c) 2017-2020 xxx公司
 */
package testClasses;

/**
 * @version: V1.0
 * @author: LZY
 * @className: ColorPrinter
 * @packageName: testClasses
 * @description:
 * @data: 2020-12-31 14:49
 **/
public class ColorPrinter implements Ink{
    @Override
    public void print() {
        System.err.println("红色打印");
    }
}