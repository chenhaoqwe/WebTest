/**
 * projectName: WebTest
 * fileName: ServletTest.java
 * packageName: servlet
 * date: 2021-01-02 16:43
 * copyright(c) 2017-2020 xxx公司
 */
package servlet;

import javafx.print.Printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version: V1.0
 * @author: LZY
 * @className: ServletTest
 * @packageName: servlet
 * @description: testServlet
 * @data: 2021-01-02 16:43
 **/
@WebServlet(name = "test1", urlPatterns = {"/testServlet"}, loadOnStartup = 1)
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is doGet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is doPost");
    }
}