/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 前回認定調査結果との比較表のReportです。
 *
 * @reamsid_L DBE-0080-120 duanzhanli
 */
public final class ChosahyoSaiCheckhyoReport extends Report<ChosahyoSaiCheckhyoReportSource> {

    private final List<ChosahyoSaiCheckhyoItem> itemList;
    private final ChosahyoSaiCheckhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 前回認定調査結果との比較表のITEMLIST
     * @return 前回認定調査結果との比較表のReport
     */
    public static ChosahyoSaiCheckhyoReport createFrom(
            List<ChosahyoSaiCheckhyoItem> itemList) {

        return new ChosahyoSaiCheckhyoReport(itemList, null);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 前回認定調査結果との比較表のITEM
     * @return 前回認定調査結果との比較表のReport
     */
    public static ChosahyoSaiCheckhyoReport createFrom(
            ChosahyoSaiCheckhyoItem item) {
        return new ChosahyoSaiCheckhyoReport(null, item);
    }

    private ChosahyoSaiCheckhyoReport(List<ChosahyoSaiCheckhyoItem> itemList, ChosahyoSaiCheckhyoItem item) {
        this.itemList = itemList;
        this.item = item;
    }

    /**
     * @param reportSourceWriter 前回認定調査結果との比較表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoSaiCheckhyoReportSource> reportSourceWriter) {
        if (itemList != null) {
            for (ChosahyoSaiCheckhyoItem chosahyoSaiCheckhyoItem : itemList) {
                IChosahyoSaiCheckhyoEditor editor = new ChosahyoSaiCheckhyoEditor(chosahyoSaiCheckhyoItem);
                IChosahyoSaiCheckhyoBuilder builder = new ChosahyoSaiCheckhyoBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IChosahyoSaiCheckhyoEditor editor = new ChosahyoSaiCheckhyoEditor(item);
            IChosahyoSaiCheckhyoBuilder builder = new ChosahyoSaiCheckhyoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
