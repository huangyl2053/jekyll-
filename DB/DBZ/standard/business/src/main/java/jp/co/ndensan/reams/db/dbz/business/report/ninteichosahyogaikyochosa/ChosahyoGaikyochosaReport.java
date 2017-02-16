/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（概況調査）のReportです。
 *
 * @reamsid_L DBE-0080-030 xuyannan
 */
public class ChosahyoGaikyochosaReport extends Report<ChosahyoGaikyochosaReportSource> {

    private final List<ChosahyoGaikyochosaItem> itemList;
    private final ChosahyoGaikyochosaItem item;
    private final int layoutIndex;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(List<ChosahyoGaikyochosaItem> itemList) {
        return new ChosahyoGaikyochosaReport(itemList, null, 0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(ChosahyoGaikyochosaItem item) {
        return new ChosahyoGaikyochosaReport(null, item, 0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     * @param layoutIndex
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(List<ChosahyoGaikyochosaItem> itemList, int layoutIndex) {
        return new ChosahyoGaikyochosaReport(itemList, null, layoutIndex);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（概況調査）のItem
     * @param layoutIndex
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(ChosahyoGaikyochosaItem item, int layoutIndex) {
        return new ChosahyoGaikyochosaReport(null, item, layoutIndex);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItemList
     * @param item 要介護認定調査票（概況調査）のItem
     * @param layoutIndex
     */
    protected ChosahyoGaikyochosaReport(List<ChosahyoGaikyochosaItem> itemList, ChosahyoGaikyochosaItem item, int layoutIndex) {
        this.itemList = itemList;
        this.item = item;
        this.layoutIndex = layoutIndex;
    }

    /**
     * 要介護認定調査票（概況調査）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter) {
        if (itemList != null) {
            for (ChosahyoGaikyochosaItem chosahyoGaikyochosaItem : itemList) {
                IChosahyoGaikyochosaEditor editor = new ChosahyoGaikyochosaEditorImpl(chosahyoGaikyochosaItem, layoutIndex);
                IChosahyoGaikyochosaBuilder builder = new ChosahyoGaikyochosaBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IChosahyoGaikyochosaEditor editor = new ChosahyoGaikyochosaEditorImpl(item, layoutIndex);
            IChosahyoGaikyochosaBuilder builder = new ChosahyoGaikyochosaBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
