package shixun;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author shenchao
 * 柱状图
 */
public class BarChart {

    public BarChart() {
    }


    /**
     * @param map 构建柱状图的键值对集合
     */
    public void showChart(Map<String, Double> map) {
        // 创建饼图数据对象
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Set<Entry<String, Double>> set = map.entrySet();
        for (Entry<String, Double> entry : set) {
            dataset.setValue(entry.getValue(), "评论数量", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart("", "",
                "", dataset, PlotOrientation.VERTICAL, false, true, true);
        ChartFrame frame = new ChartFrame("", chart, true);

        chart.setBackgroundPaint(Color.WHITE);
        // 获得 plot：3dBar为CategoryPlot
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        // 设定图表数据显示部分背景色
        categoryPlot.setBackgroundPaint(Color.WHITE);
        // 横坐标网格线
        categoryPlot.setDomainGridlinePaint(Color.GRAY);
        // 设置网格线可见
        categoryPlot.setDomainGridlinesVisible(true);
        // 纵坐标网格线
        categoryPlot.setRangeGridlinePaint(Color.GRAY);
        // 获取纵坐标
        NumberAxis numberaxis = (NumberAxis) categoryPlot.getRangeAxis();

        // 设置纵坐标的标题字体和大小
        numberaxis.setLabelFont(new Font("黑体", Font.BOLD, 16));
        // 设置丛坐标的坐标值的字体颜色
        numberaxis.setLabelPaint(Color.BLACK);
        // 设置丛坐标的坐标轴标尺颜色
        numberaxis.setTickLabelPaint(Color.BLACK);
        // 坐标轴标尺颜色
        numberaxis.setTickMarkPaint(Color.BLUE);
        // 设置丛坐标间距值
        numberaxis.setAutoTickUnitSelection(true);
        numberaxis.setTickUnit(new NumberTickUnit(0.1));
        numberaxis.setRangeWithMargins(0.1, 0.87);

        //在柱体的上面显示数据
        BarRenderer customBarRenderer3d = new BarRenderer();
        categoryPlot.setRenderer(customBarRenderer3d);


        // 获取横坐标
        CategoryAxis domainAxis = categoryPlot.getDomainAxis();
        // 设置横坐标的标题字体和大小
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 16));
        // 设置横坐标的坐标值的字体颜色
        domainAxis.setTickLabelPaint(Color.GRAY);
        // 设置横坐标的坐标值的字体
        domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 16));
        // 设置横坐标的显示
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(0.4));
        // 设置图例标题
        Font font = new Font("黑体", Font.BOLD, 20);
        TextTitle title = new TextTitle("");
        title.getBackgroundPaint();
        title.setFont(font);
        // 设置标题的字体颜色
        chart.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }
}