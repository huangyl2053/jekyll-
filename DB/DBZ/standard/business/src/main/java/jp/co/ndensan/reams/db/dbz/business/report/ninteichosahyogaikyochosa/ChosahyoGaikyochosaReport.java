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

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(List<ChosahyoGaikyochosaItem> itemList) {
        return new ChosahyoGaikyochosaReport(itemList, null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(ChosahyoGaikyochosaItem item) {
        return new ChosahyoGaikyochosaReport(null, item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItemList
     * @param item 要介護認定調査票（概況調査）のItem
     */
    protected ChosahyoGaikyochosaReport(List<ChosahyoGaikyochosaItem> itemList, ChosahyoGaikyochosaItem item) {
        this.itemList = itemList;
        this.item = item;
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
                IChosahyoGaikyochosaEditor editor = new ChosahyoGaikyochosaEditorImpl(chosahyoGaikyochosaItem);
                IChosahyoGaikyochosaBuilder builder = new ChosahyoGaikyochosaBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IChosahyoGaikyochosaEditor editor = new ChosahyoGaikyochosaEditorImpl(item);
            IChosahyoGaikyochosaBuilder builder = new ChosahyoGaikyochosaBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
