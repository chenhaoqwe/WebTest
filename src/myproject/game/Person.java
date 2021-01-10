/**
 * projectName: WebTest
 * fileName: Person.java
 * packageName: myproject.game
 * date: 2021-01-06 21:47
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.game;

import java.util.Scanner;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Person
 * @packageName: myproject.game
 * @description: 玩家类
 * @data: 2021-01-06 21:47
 **/
public class Person {
    //给自己输入名字
    private String name = "匿名";
    //积分
    private int score = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 人出拳
     *
     * @return
     */
    public int showFist() {
        //定义输入对象
        Scanner input = new Scanner(System.in);
        int num = 1;
        //循环直到输正确为止
        while (true) {
            System.out.println("请出拳(1表示剪刀，2表示石头、3表示布)：");
            //判断是否输入的是整数
            if (input.hasNextInt()) {
                //把输入的整数赋值给前面的num变量
                num = input.nextInt();
                //判断范围是否正确
                if (num < 1 || num > 3) {
                    System.out.println("请输入整数1或2或3：");
                    continue;
                }
            } else {
                input.nextLine();
            }
            return num;
        }
    }
}