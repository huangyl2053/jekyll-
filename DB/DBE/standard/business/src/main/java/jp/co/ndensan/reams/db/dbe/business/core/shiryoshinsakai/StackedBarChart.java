/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Stroke;
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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
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
    private static final int INT_GOGO = 2500;
    private static final int INT_NIGO = 250;
    private static final int INT_NITI = 270;
    private static final int INT_180 = 180;
    private static final int INT_220 = 220;
    private static final int INT_120 = 120;
    private static final int COLOR_PATTERN = 4;
    private static final int BARCHART_MAX_WIDTH = 125;
    private static final int INT_255 = 255;
    private static final int BARCHART_MAX_COUNT = 9;
    private static final float STROKE = 3.0f;

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
        JPanel jpanel = createDemoPanel(食事, 排泄, 移動, 清潔保持, 0, 0, 0, 0, 0, 文件名, RString.EMPTY);
        jpanel.setPreferredSize(new Dimension(INT_GO, INT_NITI));
        setContentPane(jpanel);
    }

    /**
     * PNG作成します。
     *
     * @param 食事 食事
     * @param 排泄 排泄
     * @param 移動 移動
     * @param 清潔保持 清潔保持
     * @param 間接ケア 間接ケア
     * @param bpsd関連 bpsd関連
     * @param 機能訓練 機能訓練
     * @param 医療関連 医療関連
     * @param 認知症加算 認知症加算
     * @param 文件名 文件名
     * @param ファイルパス ファイルパス
     */
    public StackedBarChart(int 食事, int 排泄, int 移動, int 清潔保持, int 間接ケア, int bpsd関連, int 機能訓練,
            int 医療関連, int 認知症加算, RString 文件名, RString ファイルパス) {
        super(RString.EMPTY.toString());
        JPanel jpanel = createDemoPanel(食事, 排泄, 移動, 清潔保持, 間接ケア, bpsd関連, 機能訓練, 医療関連, 認知症加算, 文件名, ファイルパス);
        jpanel.setPreferredSize(new Dimension(INT_GO, INT_NITI));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset(int 食事, int 排泄, int 移動, int 清潔保持,
            int 間接ケア, int bpsd関連, int 機能訓練, int 医療関連, int 認知症加算) {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(食事, "Series 1", "");
        defaultcategorydataset.addValue(排泄, "Series 2", "");
        defaultcategorydataset.addValue(移動, "Series 3", "");
        defaultcategorydataset.addValue(清潔保持, "Series 4", "");
        defaultcategorydataset.addValue(間接ケア, "Series 5", "");
        defaultcategorydataset.addValue(bpsd関連, "Series 6", "");
        defaultcategorydataset.addValue(機能訓練, "Series 7", "");
        defaultcategorydataset.addValue(医療関連, "Series 8", "");
        defaultcategorydataset.addValue(認知症加算, "Series 9", "");
        int other = BARCHART_MAX_WIDTH - (食事 + 排泄 + 移動 + 清潔保持 + 間接ケア + bpsd関連 + 機能訓練 + 医療関連 + 認知症加算);
        defaultcategorydataset.addValue(other, "Series 10", "");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset, RString 文件名, RString ファイルパス) {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("", "", "", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p = jfreechart.getCategoryPlot();
        p.setBackgroundPaint(ChartColor.WHITE);
        jfreechart.setPadding(new RectangleInsets(INT_JYUU, 0, INT_JYUU, 0));
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        Stroke stroke = new BasicStroke(STROKE);
        categoryplot.setOutlineStroke(stroke);
        BarRenderer barRenderer = ((BarRenderer) categoryplot.getRenderer());
        barRenderer.setBarPainter(new StandardBarPainter());
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer) categoryplot.getRenderer();
        for (int index = 0; index <= BARCHART_MAX_COUNT; index++) {
            int colorPattern = index % COLOR_PATTERN;
            if (index == BARCHART_MAX_COUNT) {
                stackedbarrenderer.setSeriesPaint(index, new Color(INT_255, INT_255, INT_255, 0));
            } else if (colorPattern == INT_ZERO) {
                stackedbarrenderer.setSeriesPaint(index, new Color(INT_ZERO, INT_ZERO, INT_ZERO));
            } else if (colorPattern == INT_ICHI) {
                stackedbarrenderer.setSeriesPaint(index, new Color(INT_120, INT_120, INT_120));
            } else if (colorPattern == INT_NI) {
                stackedbarrenderer.setSeriesPaint(index, new Color(INT_220, INT_220, INT_220));
            } else if (colorPattern == INT_SAN) {
                stackedbarrenderer.setSeriesPaint(index, new Color(INT_180, INT_180, INT_180));
            }
        }
        final NumberAxis rangeAxis = (NumberAxis) categoryplot.getRangeAxis();
        rangeAxis.setAxisLineVisible(false);
        rangeAxis.setVisible(false);
        try {
            ChartUtilities.saveChartAsPNG(
                    new File((RString.isNullOrEmpty(ファイルパス) ? Path.getUserHomePath().toString() : ファイルパス) + "\\" + 文件名 + ".png"),
                    jfreechart, INT_GOGO, INT_NIGO);
        } catch (IOException e) {
            return null;
        }
        return jfreechart;
    }

    private static JPanel createDemoPanel(int 食事, int 排泄, int 移動, int 清潔保持,
            int 間接ケア, int bpsd関連, int 機能訓練, int 医療関連, int 認知症加算, RString 文件名, RString ファイルパス) {
        JFreeChart jfreechart = createChart(createDataset(食事, 排泄, 移動, 清潔保持, 間接ケア,
                bpsd関連, 機能訓練, 医療関連, 認知症加算), 文件名, ファイルパス);
        return new ChartPanel(jfreechart);
    }
}
