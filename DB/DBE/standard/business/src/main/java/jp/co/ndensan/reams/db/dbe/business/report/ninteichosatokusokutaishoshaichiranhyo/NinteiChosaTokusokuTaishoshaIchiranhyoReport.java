/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書督促対象者一覧表のReportです。
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReport extends Report<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    private final List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 主治医意見書督促対象者一覧表のITEM
     * @return 主治医意見書督促対象者一覧表のReport
     */
    public static NinteiChosaTokusokuTaishoshaIchiranhyoReport createFrom(
            List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList) {
        return new NinteiChosaTokusokuTaishoshaIchiranhyoReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 主治医意見書督促対象者一覧表のITEM
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoReport(
            List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList) {

        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter) {
        int index = 1;
        for (NinteiChosaTokusokuTaishoshaIchiranhyoItem item : itemList) {
            INinteiChosaTokusokuTaishoshaIchiranhyoEditor editor = new NinteiChosaTokusokuTaishoshaIchiranhyoEditor(item, index);
            INinteiChosaTokusokuTaishoshaIchiranhyoBuilder builder = new NinteiChosaTokusokuTaishoshaIchiranhyoBulider(editor);
            index = index + 1;
            reportSourceWriter.writeLine(builder);
        }
    }
}
