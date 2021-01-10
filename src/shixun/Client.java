package shixun;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @title: Client
 * @package shixun
 * @description:
 * @author: LZY
 * @date: 2021-01-03 1:27
 * @version: V1.0
 */
class Client {
    private static final Scanner SC = new Scanner(System.in);
    public static final String PATH_SOURCE = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\特征集及说明\\uk-2006-05.content_based_features.csv";
    public static final String PATH_LABEL = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\IdNameLabel.txt";
    public static final String DIR_SPLIT_OUT = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\";
    public static final String PATH_SPLIT_OUT = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\mergeOutput.csv";
    public static final String PATH_TRAIN_CSV = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\train.csv";
    public static final String PATH_TEST_CSV = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\test.csv";
    public static final String PATH_TRAIN_ARFF = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\train.arff";
    public static final String PATH_TEST_ARFF = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\test.arff";

    public static final String PATH_PREDICT_RESULT_J48 = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\result_Label_J48.txt";
    public static final String PATH_PREDICT_RESULT_LOGISTIC = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\result_Label_Logistic.txt";
    public static final String PATH_PREDICT_RESULT_MULTILAYER_PERCEPTRON = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\result_Label_MultilayerPerceptron.txt";
    public static final String PATH_PREDICT_RESULT_MULTILAYER_RandomForest = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\result_Label_RandomForest.txt";
    public static final String PATH_PREDICT_RESULT_SMO = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\result_Label_SMO.txt";
    public static final String PATH_PREDICT_INTEGRATED = "F:\\study\\bishe\\人工智能实训\\web span相关数据集\\final\\result_Label_Integrated.txt";

    public static final String MENU = "请输入指令：\n"
            + "1：把没有label的源数据集和label文件合并\n"
            + "2：把合并后的文件根据label分成两个文件\n"
            + "3：制造train集和test集\n"
            + "4：训练集测试集转换成weka识别的arff\n"
            + "5：调用weka的某算法构建模型进行预测,并输出预测结果\n"
            + "6：投票集成算法,并输出结果\n"
            + "7：生成图表并查看\n"
            + "0:退出";


    public static void main(String[] args) {
        run();
    }

    /**
     * 调用合并成一个文件方法
     */
    public static void merge() {
        List<String[]> mergeList = CsvOperator.mergeTwoSortList(CsvOperator.readCsv(PATH_SOURCE, ",")
                , CsvOperator.readCsv(PATH_LABEL, " "));
        if (CsvOperator.outputCsv(PATH_SPLIT_OUT, mergeList)) {
            System.out.print("输出成功");
        }
    }

    /**
     * 调用根据label分成两个文件方法
     */
    public static void mergeByLabel() {
        List<String[]> mergeList = CsvOperator.mergeTwoSortList(CsvOperator.readCsv(PATH_SOURCE, ",")
                , CsvOperator.readCsv(PATH_LABEL, " "));
        if (CsvOperator.outputCsvByClass(DIR_SPLIT_OUT, mergeList)) {
            System.out.print("输出成功");
        }
    }

    /**
     * 调用根据mode生成训练集测试集方法
     *
     * @param mode "order" for 顺序 "cross" for 交叉
     */
    public static void generateTrainAndTest(String mode) {
        CsvOperator.generateTrainAndTest(DIR_SPLIT_OUT + "normalOutput.csv", DIR_SPLIT_OUT + "spamOutput.csv", PATH_TRAIN_CSV, PATH_TEST_CSV, mode);
    }

    /**
     * 调用训练集测试集转换成arff方法
     */
    public static void convert() {
        if (CsvOperator.csvToArff(PATH_TRAIN_CSV, PATH_TRAIN_ARFF)) {
            System.out.println("训练数据集转换arff成功");
        }
        if (CsvOperator.csvToArff(PATH_TEST_CSV, PATH_TEST_ARFF)) {
            System.out.println("测试数据集转换arff成功");
        }
    }

    /**
     * 调用分类方法
     */
    public static void classify() {
        String sb = "选择使用的分类器\n" +
                "1、J48\n2、Logistic\n3、MultilayerPerceptron\n4、RandomForest\n5、SMO\n";
        System.out.println(sb);

        AbstractClassifier classifier = null;
        String pathTestResult = null;
        int cmd;
        cmd = SC.nextInt();
        switch (cmd) {
            case 1:
                classifier = new J48();
                pathTestResult = PATH_PREDICT_RESULT_J48;
                break;
            case 2:
                classifier = new Logistic();
                pathTestResult = PATH_PREDICT_RESULT_LOGISTIC;
                break;
            case 3:
                classifier = new MultilayerPerceptron();
                pathTestResult = PATH_PREDICT_RESULT_MULTILAYER_PERCEPTRON;
                break;
            case 4:
                classifier = new RandomForest();
                pathTestResult = PATH_PREDICT_RESULT_MULTILAYER_RandomForest;
                break;
            case 5:
                classifier = new SMO();
                pathTestResult = PATH_PREDICT_RESULT_SMO;
                break;
            default:
                System.err.println("只能输入1，2,3,4,5");
                break;
        }

        Classifier.classify(classifier, PATH_TRAIN_ARFF, PATH_TEST_ARFF, pathTestResult);

    }

    /**
     * 调用选择集成方法
     */
    public static void integrate() {
        Evaluation.outputMostSelect(PATH_PREDICT_INTEGRATED, PATH_PREDICT_RESULT_J48
                , PATH_PREDICT_RESULT_LOGISTIC, PATH_PREDICT_RESULT_MULTILAYER_PERCEPTRON);
        //PATH_PREDICT_RESULT_MULTILAYER_RandomForest, PATH_PREDICT_RESULT_SMO);
    }

    /**
     * 调用图标展示可视化方法
     */
    public static void showInChart() {
        Evaluation.resultShowInChart(PATH_TEST_CSV, PATH_PREDICT_RESULT_J48,
                PATH_PREDICT_RESULT_LOGISTIC, PATH_PREDICT_RESULT_MULTILAYER_PERCEPTRON, PATH_PREDICT_INTEGRATED);
        //, PATH_PREDICT_RESULT_MULTILAYER_RandomForest, PATH_PREDICT_RESULT_SMO, PATH_PREDICT_INTEGRATED);
    }

    /**
     * main函数主题方法
     */
    public static void run() {
        byte cmd;
        while (true) {
            System.out.println(MENU);
            try {
                cmd = SC.nextByte();
            } catch (InputMismatchException e) {
                System.err.println("只能输入数字");
                SC.nextLine();
                continue;
            }
            switch (cmd) {
                case 1:
                    merge();
                    break;
                case 2:
                    mergeByLabel();
                    break;
                case 3:
                    System.out.println("输入模式1或2，或0返回上一级");
                    while (true) {
                        try {
                            int code;

                            code = SC.nextInt();
                            if (1 == code) {
                                generateTrainAndTest("order");
                                break;
                            } else if (2 == code) {
                                generateTrainAndTest("cross");
                                break;
                            } else if (0 == code) {
                                break;
                            } else {
                                System.err.println("只能输入1或者2，或0返回上一级");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("只能输入数字");
                            SC.nextLine();
                        }
                    }
                    break;
                case 4:
                    convert();
                    break;
                case 5:
                    classify();
                    break;
                case 6:
                    integrate();
                    break;
                case 7:
                    showInChart();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("请输入0-7");
                    break;
            }
        }
    }
}
