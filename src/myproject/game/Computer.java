/**
 * projectName: WebTest
 * fileName: Computer.java
 * packageName: myproject.game
 * date: 2021-01-06 21:47
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.game;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Computer
 * @packageName: myproject.game
 * @description: 电脑类
 * @data: 2021-01-06 21:47
 **/
public class Computer {
    /**
     * 对决是计算机名字
     */

    private String name = "电脑";
    /**
     * 计算机得到的分数
     */
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
     * 计算机出拳
     *
     * @return
     */
    public int showFist() {
        //让计算机产生1,2,3的随机数
        int num = (int) (Math.random() * 3) + 1;
        //分支判断
        switch (num) {
            case 1:
                System.out.println(name + "出拳是：剪刀");
                break;
            case 2:
                System.out.println(name + "出拳是：石头");
                break;
            case 3:
                System.out.println(name + "出拳是：布");
                break;
        }
        //返回计算机出的券
        return num;
    }


}
