package shixun;

import shixun.FileManage;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @title: EvaluationMeasure
 * @package shixun.ContentNewLinkIntegration
 * @description:
 * @author: LZY
 * @date: 2021-01-02 23:39
 * @version: V1.0
 */
public class Classifier {
    public static void classify(AbstractClassifier classifier, String trainSet, String testSet, String testResult) {
        File trainFile = new File(trainSet);
        File testFile = new File(testSet);
        File testResultFile = new File(testResult);

        FileWriter fwTestResult = null;
        PrintWriter pwTestResult = null;

        ArffLoader trainLoader;
        ArffLoader testLoader;

        Instances trainIns;
        Instances testIns;
        try {
            fwTestResult = new FileWriter(testResultFile);
            pwTestResult = new PrintWriter(fwTestResult);

            trainLoader = new ArffLoader();
            testLoader = new ArffLoader();
            trainLoader.setFile(trainFile);
            testLoader.setFile(testFile);
            trainIns = trainLoader.getDataSet();
            testIns = testLoader.getDataSet();
            trainIns.setClassIndex(trainIns.numAttributes() - 1);
            testIns.setClassIndex(testIns.numAttributes() - 1);
            //训练出模型
            classifier.buildClassifier(trainIns);
            //分类器用于对测试集进行分类并输出分类结果
            System.out.println(classifier.getClass().getName() + "方法使用" + trainSet + "训练，使用" + testSet + "测试的结果");
            //评价训练出来的模型
            Evaluation evaluation = new Evaluation(testIns);
            //评价训练模型
            evaluation.evaluateModel(classifier, testIns);
            System.out.println(evaluation.toClassDetailsString());
            System.out.println();
            System.out.println(evaluation.toMatrixString());
            System.out.println();
            System.out.println(evaluation.toSummaryString());

            //将J48决策树方法对Test的分类结果分别写到TestResults文件中
            for (int i = 0; i < testIns.numInstances(); i++) {
                //进行分类预测
                double classLabel = classifier.classifyInstance(testIns.instance(i));
                double diff = 1e-6f;
                if (Math.abs(classLabel - 0.0) < diff) {
                    pwTestResult.println("spam");
                } else {
                    pwTestResult.println("normal");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileManage.close(fwTestResult, pwTestResult);
            System.out.println(classifier.getClass().getName() + "方法分类算法执行完毕");
        }

    }
}
