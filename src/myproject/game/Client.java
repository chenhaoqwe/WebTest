/**
 * projectName: WebTest
 * fileName: Client.java
 * packageName: myproject.game
 * date: 2021-01-06 22:29
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Client
 * @packageName: myproject.game
 * @description: 测试类
 * @data: 2021-01-06 22:29
 **/
public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }


    private Client() {

    }


    /**
     * 猜数字游戏(100以内)，三次机会，如果结果猜对了获胜！每次失败电脑提示数字猜大了还是小了好让用户选择往哪个范围猜。
     */
    public static void guessNumberGame() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        //100以内的数字：0~100
        int randomNum = random.nextInt(101);
        boolean result = false;
        int guess;
        while (!result) {
            System.out.println("请猜测数字（0~100）：");
            try {
                guess = sc.nextInt();
                if (guess < 0 || guess > 100) {
                    System.out.println("只能输入0~100");
                } else if (guess == randomNum) {
                    System.out.println("恭喜你猜中了");
                    result = true;
                } else if (guess < randomNum) {
                    System.out.println("猜小了");
                } else {
                    System.out.println("猜大了");
                }
            } catch (InputMismatchException e) {
                System.out.println("只能输入数字");
                sc.nextLine();
            }

        }

    }
}