/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（概況調査）のReportです。
 */
public class ChosahyoGaikyochosaReport extends Report<ChosahyoGaikyochosaReportSource> {

    private final List<ChosahyoGaikyochosaItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     * @return 要介護認定調査票（概況調査）のReport
     */
    public static ChosahyoGaikyochosaReport createFrom(List<ChosahyoGaikyochosaItem> itemList) {
        return new ChosahyoGaikyochosaReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 要介護認定調査票（概況調査）のItem
     */
    protected ChosahyoGaikyochosaReport(List<ChosahyoGaikyochosaItem> itemList) {
        this.itemList = itemList;
    }

    /**
     * 要介護認定調査票（概況調査）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoGaikyochosaReportSource> reportSourceWriter) {
        for (ChosahyoGaikyochosaItem item : itemList) {
            IChosahyoGaikyochosaEditor editor = new ChosahyoGaikyochosaEditorImpl(item);
            IChosahyoGaikyochosaBuilder builder = new ChosahyoGaikyochosaBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
