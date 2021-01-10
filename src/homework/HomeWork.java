package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HomeWork<T extends Comparable<T>> {
    int a;

    public class Competition {
        //比赛选手号和成绩对照表
        private Map<Integer, Double> numScoreMap = new HashMap<Integer, Double>();
        //比赛选手号和姓名对照表
        private Map<Integer, String> numNameMap = new HashMap<Integer, String>();
        //选手个数
        private int length;

        public Competition() {

        }

        public Competition(Map<Integer, Double> numScoreMap, Map<Integer, String> numNameMap, int length) {
            this.numScoreMap = numScoreMap;
            this.numNameMap = numNameMap;
            this.length = length;
        }

        public Map<Integer, Double> getNumScoreMap() {
            return numScoreMap;
        }

        public void setNumScoreMap(Map<Integer, Double> numScoreMap) {
            this.numScoreMap = numScoreMap;
        }

        public Map<Integer, String> getNumNameMap() {
            return numNameMap;
        }

        public void setNumNameMap(Map<Integer, String> numNameMap) {
            this.numNameMap = numNameMap;
        }


        public Map<Integer, Double> getNameScoreMap() {
            return numScoreMap;
        }

        public void setNameScoreMap(Map<Integer, Double> nameScoreMap) {
            this.numScoreMap = nameScoreMap;
        }

        public int getLength() {
            return this.length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        /**
         * 获取平均分
         *
         * @return 平均分
         */
        public double getAveScore() {
            Iterator<Map.Entry<Integer, Double>> it = this.numScoreMap.entrySet().iterator();
            double sum = 0d;
            while (it.hasNext()) {
                Map.Entry<Integer, Double> entry = it.next();
                sum += entry.getValue().doubleValue();

            }
            return sum / this.length;
        }

        /**
         * 获取最高分
         *
         * @return 最高分
         */
        public double getMaxScore() {
            Iterator<Map.Entry<Integer, Double>> it = this.numScoreMap.entrySet().iterator();
            double max = this.numScoreMap.get(1);
            while (it.hasNext()) {
                Map.Entry<Integer, Double> entry = it.next();
                if (max < entry.getValue().doubleValue()) {
                    max = entry.getValue().doubleValue();
                }
            }
            return max;
        }

        /**
         * 获取最高分选手
         *
         * @return 最高分选手
         */
        public String getMaxPlayer() {
            Iterator<Map.Entry<Integer, Double>> it = this.numScoreMap.entrySet().iterator();
            double max = this.numScoreMap.get(1);
            int maxPlayerNum=1;
            while (it.hasNext()) {
                Map.Entry<Integer, Double> entry = it.next();
                if (max < entry.getValue().doubleValue()) {
                    max = entry.getValue().doubleValue();
                    maxPlayerNum=entry.getKey().intValue();
                }
            }
            return numNameMap.get(maxPlayerNum).toString();
        }
    }

    public T findMax(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (1 == arr[i].compareTo(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    public int getNum(T n) {
        if (n instanceof Double) {
            return Double.valueOf((Double) n).intValue();
        } else return -1;
    }
}
