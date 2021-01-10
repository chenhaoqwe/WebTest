package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
/*        //动态输入
        Scanner input = new Scanner(System.in);
        System.out.println("请先设计几个数的比较：");
        int len = input.nextInt();
        int[] arr = new int[len];
        //依次输入这些数
        for (int i = 0; i < len; i++) {
            System.out.println("请输入第" + (i + 1) + "个数:");
            arr[i] = input.nextInt();
        }
//        int[] arr = {6, 8, 9, 7, 26, 5};
        int max = test.getMin(arr);
        //输出最值
        System.out.println("最小值是：" + max);*/
/*        int num='c';
        System.out.println(num);*/
/*        char[] arr = {'x', 'n', 'g', 't'};
        char last = test.getMaxChar(arr);
        System.out.println(last);*/
/*        int[] arr = {4, 5, 6, 3, 46};
        int[] result = test.bubbleSort(arr);
        for (int item : result) {
            System.out.print(item + " ");
        }*/
/*        HomeWork<Double> hm = new HomeWork<Double>();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组长度");
        int len = sc.nextInt();
        Double[] arr = new Double[len];
        for (int i = 0; i < len; i++) {
            System.out.println("请输入第" + (i + 1) + "个数");
            arr[i] = sc.nextDouble();
        }
        double max = hm.findMax(arr);
        System.out.println(max);*/

/*      HomeWork<Double> hm = new HomeWork<Double>();
        System.out.println(hm.getNum(6.44));*/
        //作业类对象hm
        HomeWork hm = new HomeWork();
        //比赛选手号和成绩对照表
        Map<Integer, Double> numScoreMap = new HashMap<Integer, Double>();
        //比赛选手号和姓名对照表
        Map<Integer, String> numNameMap = new HashMap<Integer, String>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String name;
        Double score;
        System.out.println("输入有几个学生");
        int n = scanner.nextInt();
        //记录有多少人参赛
        for (i = 0; i < n; i++) {
            System.out.println("输入第" + (i + 1) + "个学生的姓名");
            name = scanner.next();
            System.out.println("输入第" + (i + 1) + "个学生的成绩");
            score = scanner.nextDouble();
            //比赛选手号和成绩对照表中添加记录
            numScoreMap.put((i + 1), score);
            //比赛选手号和姓名对照表中添加记录
            numNameMap.put((i + 1), name);
        }
        //使用有参构造函数来用作业类对象hm创建作业类的内部类Competition的对象competition
        HomeWork.Competition competition = hm.new Competition(numScoreMap, numNameMap, n);
        System.out.println("比赛的平均分是：" + competition.getAveScore());
        System.out.println("比赛的最高分是：" + competition.getMaxScore());
        System.out.println("获得比赛最高分的选手是：" + competition.getMaxPlayer());
    }

    public int getMax(int[] arr) {
        int max = arr[0];//先假定第一个元素最大
        //让后面从第二个开始的元素依次比较
        for (int i = 1; i < arr.length; i++) {
            //让后面比较大的值覆盖max
            if (arr[i] > max) {
                max = arr[i];
            }
        }//结束for循环
        return max;
    }

    public int getMin(int[] arr) {
        int min = arr[0];//先假定第一个元素最大
        //让后面从第二个开始的元素依次比较
        for (int i = 1; i < arr.length; i++) {
            //让后面比较大的值覆盖max
            if (arr[i] < min) {
                min = arr[i];
            }
        }//结束for循环
        return min;
    }

    public char getMaxChar(char[] arr) {
        char max = arr[0];//先假定第一个元素最大
        //让后面从第二个开始的元素依次比较
        for (int i = 1; i < arr.length; i++) {
            //让后面比较大的值覆盖max
            if (arr[i] > max) {
                max = arr[i];
            }
        }//结束for循环
        return max;
    }

    public int[] bubbleSort(int[] arr) {
        //外层循环n-1,内层循环n-1-i
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
