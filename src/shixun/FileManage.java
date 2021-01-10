package shixun;

import java.io.*;

/**
 * @version: V1.0
 * @author: LZY
 * @className: FileManage
 * @packageName: shixun
 * @description: 管理文件
 * @data: 2021-01-02 21:38
 **/
public class FileManage {

    public static void close(Closeable... obj) {
        for (Closeable o : obj) {
            try {
                if (o != null) {
                    o.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
