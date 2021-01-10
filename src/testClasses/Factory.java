/**
 * projectName: WebTest
 * fileName: Factor.java
 * packageName: testClasses
 * date: 2020-12-31 14:46
 * copyright(c) 2017-2020 xxx公司
 */
package testClasses;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Factor
 * @packageName: testClasses
 * @description: factory
 * @data: 2020-12-31 14:46
 **/
public class Factory {
    //组装打印机
    public static Ink packagePrinter() {
        //返回组装的打印机对象
        return new ColorPrinter();
    }
}