package shixun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: CSVOperator
 * @package shixun
 * @description:
 * @author: LZY
 * @date: 2021-01-03 1:42
 * @version: V1.0
 */
public class CsvOperator {
    public static final int FILE_SIZE = 1000;

    public static boolean outputCsvByClass(String filepath, List<String[]> mergedList) {
        //文件输出状态标志
        boolean isSuccess = false;
        //创建Normal文件对象fileNormal
        File fileNormal = new File(filepath + "normalOutput.csv");
        //创建Normal文件对象fileSpam
        File fileSpam = new File(filepath + "spamOutput.csv");
        //创建文件输出流对象outNormal
        FileWriter fwNormal = null;
        //创建缓冲输出对象bwNormal
        BufferedWriter bwNormal = null;
        //创建文件输出流对象outSpam
        FileWriter fwSpam = null;
        //创建缓冲输出对象bwSpam
        BufferedWriter bwSpam = null;
        try {
            fwNormal = new FileWriter(fileNormal);
            bwNormal = new BufferedWriter(fwNormal);

            fwSpam = new FileWriter(fileSpam);
            bwSpam = new BufferedWriter(fwSpam);

            for (String s : mergedList.get(0)) {
                bwNormal.append(s).append(",");
            }
            bwNormal.append("\r\n");

            for (String s : mergedList.get(0)) {
                bwSpam.append(s).append(",");
            }
            bwSpam.append("\r\n");


            if (!mergedList.isEmpty()) {
                for (String[] strArr : mergedList) {
                    if ("normal".equals(strArr[strArr.length - 1])) {
                        for (String str : strArr) {
                            bwNormal.append(str).append(",");
                        }
                        bwNormal.append("\r\n");
                    } else if ("spam".equals(strArr[strArr.length - 1])) {
                        for (String str : strArr) {
                            bwSpam.append(str).append(",");
                        }
                        bwSpam.append("\r\n");
                    }
                }
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileManage.close(bwNormal, fwNormal, bwSpam, fwSpam);
        }

        return isSuccess;

    }

    public static boolean outputCsv(String filepath, List<String[]> stringList) {
        //文件输出状态标志
        boolean isSuccess = false;
        //创建文件对象file
        File file = new File(filepath);
        //创建文件写出对象fw
        FileWriter fw = null;
        //创建缓冲输出对象bw
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            if (stringList != null && !stringList.isEmpty()) {
                for (String[] strArr : stringList) {
                    for (String str : strArr) {
                        bw.append(str).append(" ");
                    }
                    bw.append("\r\n");
                }
            }
            isSuccess = true;
        } catch (Exception ignored) {
        } finally {
            FileManage.close(bw, fw);
        }

        return isSuccess;

    }

    public static List<String[]> mergeTwoSortList(List<String[]> aList,
                                                  List<String[]> bList) {
        int aListStart = 2;
        int aLength = aList.size();
        int bLength = bList.size();
        List<String[]> mergeList = new ArrayList<>();


        String[] tmp = aList.get(0);
        String[] newS = new String[tmp.length - 1];
        int t;
        for (t = aListStart; t < tmp.length; t++) {
            newS[t - 2] = tmp[t];
        }
        newS[t - 2] = "label";
        mergeList.add(newS);


        int i = 1, j = 0;
        while (i < aLength && j < bLength) {

            String[] tempStr;

            if (aList.get(i)[0].equals(bList.get(j)[0])) {
                {
                    tempStr = mergeStringArray(aList.get(i), bList.get(j));
                    i++;
                    j++;
                    mergeList.add(tempStr);
                }

            } else if (Integer.parseInt(aList.get(i)[0]) < Integer.parseInt(bList.get(j)[0])) {

                i++;
            } else {
                j++;
            }
        }

        return mergeList;

    }

    public static String[] mergeStringArray(String[] aList, String[] bList) {

        int bListStart = 2;
        int aListStart = 2;
        String[] tempStr = new String[aList.length + bList.length - aListStart - bListStart];
        int index = 0;
        for (int i = aListStart; i < aList.length; i++) {
            tempStr[index++] = aList[i];
        }
        for (int j = bListStart; j < bList.length; j++) {
            tempStr[index++] = bList[j];
        }
        return tempStr;
    }

    public static List<String[]> readCsv(String filepath, String splitCode) {
        File file = new File(filepath);
        FileReader fr = null;
        List<String[]> dataList = new ArrayList<>();
        BufferedReader br = null;
        String line;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            // int index = 0;
            while ((line = br.readLine()) != null) {
                //CSV格式文件为逗号分隔符文件，这里根据逗号切分
                String[] item = line.split(splitCode);

                dataList.add(item);
            }
        } catch (Exception ignored) {

        } finally {
            FileManage.close(br, fr);
        }
        return dataList;
    }

    public static boolean csvToArff(String csvPath, String arffPath) {
        boolean isSuccess = false;
        File csvFile = new File(csvPath);
        File arffFile = new File(arffPath);

        FileReader frCsv = null;
        BufferedReader brCsv = null;
        String line;

        FileOutputStream fosArff = null;
        OutputStreamWriter oswArff = null;
        BufferedWriter bwArff = null;

        try {
            frCsv = new FileReader(csvFile);
            brCsv = new BufferedReader(frCsv);

            fosArff = new FileOutputStream(arffFile);
            oswArff = new OutputStreamWriter(fosArff);
            bwArff = new BufferedWriter(oswArff);
            bwArff.append("@RELATION uk-2006-05.content_based_features\r\n\r\n");

            //写属性
            line = brCsv.readLine();
            String[] attributes = line.split(",");
            int i;
            for (i = 0; i < attributes.length - 1; i++) {
                bwArff.append("@ATTRIBUTE ").append(attributes[i]).append(" NUMERIC\r\n");
            }
            bwArff.append("@ATTRIBUTE ").append(attributes[i]).append(" {spam,normal}\r\n\r\n");
            bwArff.append("@DATA\r\n");

            while ((line = brCsv.readLine()) != null) {
                bwArff.append(line);
                bwArff.append("\r\n");
            }
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileManage.close(frCsv, brCsv, bwArff, oswArff, fosArff);
        }
        return isSuccess;
    }

    public static void generateTrainAndTest(String normalPath, String spamPath, String trainPath, String testPath, String mode) {
        List<String[]> normalList = readCsv(normalPath, ",");
        List<String[]> spamList = readCsv(spamPath, ",");
        File trainFile = new File(trainPath);
        File testFile = new File(testPath);
        FileWriter fwTrain = null;
        BufferedWriter bwTrain = null;
        FileWriter fwTest = null;
        BufferedWriter bwTest = null;
        int i = 0;
        int spamCount = 0;
        int normalCount = 0;
        try {
            fwTrain = new FileWriter(trainFile);
            fwTest = new FileWriter(testFile);
            bwTest = new BufferedWriter(fwTest);
            bwTrain = new BufferedWriter(fwTrain);

            for (String s : spamList.get(spamCount++)) {
                bwTrain.append(s).append(",");
            }
            bwTrain.append("\r\n");

            for (String s : normalList.get(normalCount++)) {
                bwTest.append(s).append(",");
            }
            bwTest.append("\r\n");
            String order = "order";
            String cross = "cross";

            if (order.equals(mode)) {
                for (; i < FILE_SIZE / 2; i++) {
                    for (String s : spamList.get(spamCount++)) {
                        bwTrain.append(s).append(",");
                    }
                    bwTrain.append("\r\n");
                }
                for (; i < FILE_SIZE; i++) {
                    for (String s : normalList.get(normalCount++)) {
                        bwTrain.append(s).append(",");
                    }
                    bwTrain.append("\r\n");
                }
                for (; i < FILE_SIZE + FILE_SIZE / 2; i++) {
                    for (String s : spamList.get(spamCount++)) {
                        bwTest.append(s).append(",");
                    }
                    bwTest.append("\r\n");
                }
                for (; i < FILE_SIZE + FILE_SIZE; i++) {
                    for (String s : normalList.get(normalCount++)) {
                        bwTest.append(s).append(",");
                    }
                    bwTest.append("\r\n");
                }
            } else if (cross.equals(mode)) {
                for (; i < FILE_SIZE; i++) {

                    //训练集文件中附加记录
                    if (isOdd(i)) {
                        for (String s : spamList.get(spamCount++)) {
                            bwTrain.append(s).append(",");
                        }
                    } else {
                        for (String s : normalList.get(normalCount++)) {
                            bwTrain.append(s).append(",");
                        }
                    }
                    bwTrain.append("\r\n");
                }
                for (; i < FILE_SIZE + FILE_SIZE; i++) {
                    //测试集文件中附加记录
                    if (isOdd(i)) {
                        for (String s : spamList.get(spamCount++)) {
                            bwTest.append(s).append(",");
                        }
                    } else {
                        for (String s : normalList.get(normalCount++)) {
                            bwTest.append(s).append(",");
                        }
                    }
                    bwTest.append("\r\n");
                }
            } else {
                System.err.println("mode只能是order或者cross");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileManage.close(bwTrain, fwTrain, bwTest, fwTest);
        }

    }

    public static boolean isOdd(int n) {
        int two = 2;
        return 0 != n % two;
    }
}