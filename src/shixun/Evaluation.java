/*
  projectName: WebTest
  fileName: Evaluation.java
  packageName: shixun
  date: 2021-01-02 21:25
  copyright(c) 2017-2020 xxx公司
 */
package shixun;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: Evaluation
 * @package shixun
 * @description:
 * @author: LZY
 * @date: 2021-01-02 21:27
 * @version: V1.0
 */
public class Evaluation {
    static class EvaluationMeasure {
        public double tpCount, fpCount, tnCount, fnCount;
        public double tp, fp, tn, fn, tpr, fpr;
        public double precision, recall, fMeasure, accuracy, roc, errorRate;
    }

    public static final String[] METHOD = new String[]{"J48", "Logistic", "MultilayerPerceptron", "RandomForest", "SMO", "Integrated"};



    public static void resultShowInChart(String pathSource, String... labelPath) {
        int i = 0;
        List<EvaluationMeasure> emList = new ArrayList<>();
        for (; i < labelPath.length; i++) {
            emList.add(evaluate(pathSource, labelPath[i]));
        }
        Map<String, Double> m = new LinkedHashMap<>();

        //展示precision
        for (i = 0; i < labelPath.length; i++) {
            m.put(METHOD[i].concat("_precision"), emList.get(i).precision);
        }
        m.put(" ", 0.0);
        //展示recall
        for (i = 0; i < labelPath.length; i++) {
            m.put(METHOD[i].concat("_recall"), emList.get(i).recall);
        }
        m.put("  ", 0.0);
        //展示F_measure
        for (i = 0; i < labelPath.length; i++) {
            m.put(METHOD[i].concat("_F_measure"), emList.get(i).fMeasure);
        }
        m.put("   ", 0.0);
        //展示Accuracy
        for (i = 0; i < labelPath.length; i++) {
            m.put(METHOD[i].concat("_Accuracy"), emList.get(i).accuracy);
        }

        BarChart barChart = new BarChart();
        barChart.showChart(m);
    }

    /**
     * 得到三个文件的label，存在labelList中
     *
     * @return labelList
     */
    public static List<List<String>> getLabelList(String... labelPath) {
        List<List<String>> labelList = new ArrayList<>();
        File file;
        FileReader fr = null;
        BufferedReader br = null;
        String line;


        int i = 0;
        for (; i < labelPath.length; i++) {
            List<String> tmpList = new ArrayList<>();
            labelList.add(tmpList);
            file = new File(labelPath[i]);

            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    labelList.get(i).add(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                FileManage.close(br, fr);
            }

        }
        return labelList;
    }

    /**
     * 把所有分类器分类结果进行多数投票选择
     *
     * @param labelPath 所有分类结果文件名
     * @return 投票结果
     */
    public static void outputMostSelect(String outPath, String... labelPath) {
        List<List<String>> labelList = getLabelList(labelPath);
        int[] score = new int[labelList.get(0).size()];
        File file = new File(outPath);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            int i;
            for (i = 0; i < score.length; i++) {
                for (List<String> label : labelList) {
                    if ("normal".equals(label.get(i))) {
                        score[i] += 1;
                    } else if ("spam".equals(label.get(i))) {
                        score[i] -= 1;
                    }
                }
                if (score[i] > 0) {
                    bw.append("normal\r\n");
                } else if (score[i] < 0) {
                    bw.append("spam\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileManage.close(bw, osw, fos);
        }

    }

    public static EvaluationMeasure evaluate(String pathSource, String pathResult) {
        List<String> lineSource = new ArrayList<>();
        List<String> labelSource;
        List<String> labelResult = new ArrayList<>();
        EvaluationMeasure em;

        FileReader frSource = null;
        BufferedReader brSource = null;
        FileReader frResult = null;
        BufferedReader brResult = null;
        String line;
        try {
            frSource = new FileReader(pathSource);
            brSource = new BufferedReader(frSource);
            frResult = new FileReader(pathResult);
            brResult = new BufferedReader(frResult);
            brSource.readLine();
            while ((line = brSource.readLine()) != null) {
                lineSource.add(line);
            }
            labelSource = getLabel(lineSource);
            while ((line = brResult.readLine()) != null) {
                labelResult.add(line);
            }
            em = getEvaluation(labelSource, labelResult);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            FileManage.close(brSource, frSource, brResult, frResult);
        }
        return em;
    }

    /**
     * 获取测试集label
     *
     * @param lineSource 测试集文件的所有行
     * @return 测试集文件的所有label
     */
    public static List<String> getLabel(List<String> lineSource) {
        List<String> labelSource = new ArrayList<>();
        for (String s : lineSource) {
            String[] lineItem = s.split(",");
            labelSource.add(lineItem[lineItem.length - 1]);
        }
        return labelSource;
    }

    /**
     * 获取评价
     *
     * @param labelSource 测试集的所有label
     * @param labelResult 预测结果的所有label
     * @return em
     */
    public static EvaluationMeasure getEvaluation(List<String> labelSource, List<String> labelResult) {
        EvaluationMeasure em = new EvaluationMeasure();
        double tpCount = 0;
        double fpCount = 0;
        double tnCount = 0;
        double fnCount = 0;
        double totalP = 0;
        double totalN = 0;
        int i;
        for (i = 0; i < labelSource.size(); i++) {
            if ("normal".equals(labelSource.get(i))) {
                totalP++;
                if ("normal".equals(labelResult.get(i))) {
                    tpCount++;
                } else if ("spam".equals(labelResult.get(i))) {
                    fnCount++;
                }
            } else if ("spam".equals(labelSource.get(i))) {
                totalN++;
                if ("spam".equals(labelResult.get(i))) {
                    tnCount++;
                } else if ("normal".equals(labelResult.get(i))) {
                    fpCount++;
                }
            }
        }
        double tp = tpCount / totalP;
        double fp = fpCount / totalP;
        double tn = tnCount / totalN;
        double fn = fnCount / totalN;
        double tpr = tp / (tp + fn);
        double fpr = fp / (fp + tn);
        double precision = tp / (tp + fp);
        double recall = tp / (tp + fn);
        double fMeasure = (2 * precision * recall) / (precision + recall);
        double accuracy = (tp + tn) / (tp + tn + fp + fn);
        double roc = 0;
        double errorRate = 1 - accuracy;

        em.tpCount = tpCount;
        em.fpCount = fpCount;
        em.tnCount = tnCount;
        em.fnCount = fnCount;
        em.tp = tp;
        em.fp = fp;
        em.tn = tn;
        em.fn = fn;
        em.tpr = tpr;
        em.fpr = fpr;
        em.precision = precision;
        em.recall = recall;
        em.fMeasure = fMeasure;
        em.accuracy = accuracy;
        em.roc = roc;
        em.errorRate = errorRate;
        return em;
    }
}