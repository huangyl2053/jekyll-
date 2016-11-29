/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class StackedBarChart extends ApplicationFrame {

    private static final int INT_ZERO = 0;
    private static final int INT_ICHI = 1;
    private static final int INT_NI = 2;
    private static final int INT_SAN = 3;
    private static final int INT_JYUU = 10;
    private static final int INT_GO = 500;
    private static final int INT_GOGO = 550;
    private static final int INT_NIGO = 250;
    private static final int INT_NITI = 270;
    private static final int INT_ICHINI = 128;
    private static final int INT_ICHIKYOU = 190;
    private static final int INT_ICHSAN = 139;
    private static final int INT_HATI = 87;
    private static final int INT_ROKU = 66;

    /**
     * PNG作成します。
     *
     * @param 食事 食事
     * @param 排泄 排泄
     * @param 移動 移動
     * @param 清潔保持 清潔保持
     * @param 文件名 文件名
     */
    public StackedBarChart(int 食事, int 排泄, int 移動, int 清潔保持, RString 文件名) {
        super(RString.EMPTY.toString());
        JPanel jpanel = createDemoPanel(食事, 排泄, 移動, 清潔保持, 文件名);
        jpanel.setPreferredSize(new Dimension(INT_GO, INT_NITI));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset(int 食事, int 排泄, int 移動, int 清潔保持) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(食事, "Series 1", "");
        defaultcategorydataset.addValue(排泄, "Series 2", "");
        defaultcategorydataset.addValue(移動, "Series 3", "");
        defaultcategorydataset.addValue(清潔保持, "Series 4", "");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset, RString 文件名) {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("", "", "", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p = jfreechart.getCategoryPlot();
        p.setBackgroundPaint(ChartColor.WHITE);
        jfreechart.setPadding(new RectangleInsets(INT_JYUU, INT_JYUU, INT_JYUU, INT_JYUU));
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer) categoryplot.getRenderer();
        stackedbarrenderer.setSeriesPaint(INT_ZERO, new Color(INT_ZERO, INT_ZERO, INT_ZERO));
        stackedbarrenderer.setSeriesPaint(INT_ICHI, new Color(INT_ICHSAN, INT_HATI, INT_ROKU));
        stackedbarrenderer.setSeriesPaint(INT_NI, new Color(INT_ICHIKYOU, INT_ICHIKYOU, INT_ICHIKYOU));
        stackedbarrenderer.setSeriesPaint(INT_SAN, new Color(INT_ICHINI, INT_ICHINI, INT_ICHINI));
        final NumberAxis rangeAxis = (NumberAxis) categoryplot.getRangeAxis();
        rangeAxis.setAxisLineVisible(false);
        rangeAxis.setVisible(false);
        try {
            ChartUtilities.saveChartAsPNG(
                    new File(Path.getUserHomePath().toString() + "\\" + 文件名 + ".png"), jfreechart, INT_GOGO, INT_NIGO);
        } catch (IOException e) {
            return null;
        }
        return jfreechart;
    }

    private static JPanel createDemoPanel(int 食事, int 排泄, int 移動, int 清潔保持, RString 文件名) {
        JFreeChart jfreechart = createChart(createDataset(食事, 排泄, 移動, 清潔保持), 文件名);
        return new ChartPanel(jfreechart);
    }
}
