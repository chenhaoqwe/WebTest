/**
 * projectName: WebTest
 * fileName: Game.java
 * packageName: myproject.game
 * date: 2021-01-06 21:47
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.game;

import java.util.Scanner;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Game
 * @packageName: myproject.game
 * @description: 游戏类
 * @data: 2021-01-06 21:47
 **/
public class Game {
    /**
     * 开辟创建人的对象
     */
    private Person person;
    /**
     * 开辟创建计算机的对象
     */
    private Computer computer;
    /**
     * 对战次数为0
     */
    private int count;

    public Game() {
        person = new Person();
        computer = new Computer();
        count = 0;
    }

    /**
     * 比较人和计算机的分数，谁的分数高谁胜
     *
     * @return
     */
    public int calcResult() {
        //如果分数相同，平局
        if (person.getScore() == computer.getScore()) {
            return 1;
        } else if (person.getScore() > computer.getScore()) {
            //人胜
            return 2;
        } else {
            //计算机胜
            return 3;
        }
    }

    /**
     * 显示比赛结果
     */
    public void showResult() {
        System.out.println("-------------------------------");
        System.out.println("\t\t" + person.getName() + " VS " + computer.getName());
        System.out.println("\t\t对战的次数：" + this.count);
        System.out.println("\t\t名字\t得分");
        System.out.println("\t\t【人】" + person.getName() + ":\t" + person.getScore());
        System.out.println("\t\t【电脑】" + computer.getName() + "\t" + computer.getScore());

        //调用比较人和计算机的分数
        int num = calcResult();
        if (1 == num) {
            System.out.println("结果：平手");
        } else if (2 == num) {
            System.out.println("结果：人胜");
        } else {
            System.out.println("结果：计算机胜");
        }
        System.out.println("-------------------------------");
    }

    /**
     * 开始游戏
     */
    public void start() {
        System.out.println("------------游戏开始-------------");
        System.out.println("********************************");
        System.out.println("***\t\t 猜拳游戏开始**************");
        System.out.println("********************************");
        System.out.println("\n出拳规则：1表示剪刀，2表示石头，3表示布。");
        //定义一个输入对象
        Scanner sc = new Scanner(System.in);
        String exit = "n";
        int num = 1;
        while (true) {
            System.out.println("请选择你的对手（1：刘备，2：孙权，3：曹操）：");
            if (sc.hasNextInt()) {
                //把输入的整数赋值给前面的num变量
                num = sc.nextInt();
                //判断范围是否正确
                if (num < 1 || num > 3) {
                    System.out.println("请输入整数1，2或3：");
                } else {
                    break;
                }
            } else {
                sc.nextLine();
            }
        }
        if (num == 1) {
            computer.setName("刘备");
        } else if (num == 2) {
            computer.setName("孙权");
        } else if (num == 3) {
            computer.setName("曹操");
        }
        System.out.println("请输入自己的名字：");
        //给自己的名字赋值
        sc.nextLine();
        person.setName(sc.nextLine());
        System.out.println("\t\t" + person.getName() + " VS " + computer.getName() + " 对战");

        System.out.println("要开始吗？（y/n）");
        String start = sc.nextLine();
        while ("y".equalsIgnoreCase(start)) {
            int perFist = person.showFist();
            int comFist = computer.showFist();
            //判决
            if (perFist == comFist) {
                System.out.println("该局平局");
            } else if ((perFist == 1 && comFist == 3) || (perFist == 2 && comFist == 1) || (perFist == 3 && comFist == 2)) {
                System.out.println("人胜");
                person.setScore(person.getScore() + 1);
            } else {
                System.out.println("计算机胜");
                computer.setScore(computer.getScore() + 1);
            }
            //对战次数加一
            count++;
            System.out.println("\t是否开始下一局（y/n）");
            start = sc.nextLine();
        }
        //调用显示比赛结果
        showResult();

        System.out.println("game over");
//        exit = sc.nextLine();
    }
}