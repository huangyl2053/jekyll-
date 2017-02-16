/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査票(概況調査)と認定調査票(基本調査)を一緒に出す場合の帳票編集クラスです。
 */
public class ChosahyoGaikyoAndKihonchosaReport extends Report<ChosahyoGaikyochosaReportSource> {

    private static final int LAYOUT_INDEX_概況調査 = 1;
    private static final int LAYOUT_INDEX_基本調査 = 2;
    private final List<ChosahyoGaikyochosaItem> itemList;
    private final int layoutIndex;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyoAndKihonchosaReport createFrom(List<ChosahyoGaikyochosaItem> itemList) {
        return new ChosahyoGaikyoAndKihonchosaReport(itemList, 0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyoAndKihonchosaReport createFrom(ChosahyoGaikyochosaItem item) {
        List<ChosahyoGaikyochosaItem> itemList = new ArrayList<>();
        itemList.add(item);
        return new ChosahyoGaikyoAndKihonchosaReport(itemList, 0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     * @param layoutIndex
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyoAndKihonchosaReport createFrom(List<ChosahyoGaikyochosaItem> itemList, int layoutIndex) {
        return new ChosahyoGaikyoAndKihonchosaReport(itemList, layoutIndex);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（概況調査）のItem
     * @param layoutIndex
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyoAndKihonchosaReport createFrom(ChosahyoGaikyochosaItem item, int layoutIndex) {
        List<ChosahyoGaikyochosaItem> itemList = new ArrayList<>();
        itemList.add(item);
        return new ChosahyoGaikyoAndKihonchosaReport(itemList, layoutIndex);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItemList
     */
    private ChosahyoGaikyoAndKihonchosaReport(List<ChosahyoGaikyochosaItem> itemList, int layoutIndex) {
        this.itemList = itemList;
        this.layoutIndex = layoutIndex;
    }

    /**
     * 要介護認定調査票（概況調査）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter) {
        if (layoutIndex == 1) {
            for (ChosahyoGaikyochosaItem chosahyoGaikyochosaItem : itemList) {
                IChosahyoGaikyochosaEditor editor概況 = new ChosahyoGaikyochosaEditorImpl(chosahyoGaikyochosaItem, LAYOUT_INDEX_概況調査);
                IChosahyoGaikyochosaBuilder builder概況 = new ChosahyoGaikyochosaBuilderImpl(editor概況);
                reportSourceWriter.writeLine(builder概況);
            }
        } else if (layoutIndex == 2) {
            for (ChosahyoGaikyochosaItem chosahyoGaikyochosaItem : itemList) {
                IChosahyoGaikyochosaEditor editor基本 = new ChosahyoGaikyochosaEditorImpl(chosahyoGaikyochosaItem, LAYOUT_INDEX_基本調査);
                IChosahyoGaikyochosaBuilder builder基本 = new ChosahyoGaikyochosaBuilderImpl(editor基本);
                reportSourceWriter.writeLine(builder基本);
            }
        } else {
            for (ChosahyoGaikyochosaItem chosahyoGaikyochosaItem : itemList) {
                IChosahyoGaikyochosaEditor editor概況 = new ChosahyoGaikyochosaEditorImpl(chosahyoGaikyochosaItem, LAYOUT_INDEX_概況調査);
                IChosahyoGaikyochosaBuilder builder概況 = new ChosahyoGaikyochosaBuilderImpl(editor概況);
                reportSourceWriter.writeLine(builder概況);

                IChosahyoGaikyochosaEditor editor基本 = new ChosahyoGaikyochosaEditorImpl(chosahyoGaikyochosaItem, LAYOUT_INDEX_基本調査);
                IChosahyoGaikyochosaBuilder builder基本 = new ChosahyoGaikyochosaBuilderImpl(editor基本);
                reportSourceWriter.writeLine(builder基本);
            }
        }
    }
}
