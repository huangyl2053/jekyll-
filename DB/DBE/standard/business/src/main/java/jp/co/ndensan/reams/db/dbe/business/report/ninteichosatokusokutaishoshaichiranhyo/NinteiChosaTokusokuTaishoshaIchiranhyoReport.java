/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書督促対象者一覧表のReportです。
 *
 * @reamsid_L DBE-0060-030 hezhenzhen
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReport extends Report<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoItem itemList;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 主治医意見書督促対象者一覧表のITEM
     * @param index index
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoReport(NinteiChosaTokusokuTaishoshaIchiranhyoItem itemList, int index) {
        this.itemList = itemList;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter) {
        INinteiChosaTokusokuTaishoshaIchiranhyoEditor editor = new NinteiChosaTokusokuTaishoshaIchiranhyoEditor(itemList, index);
        INinteiChosaTokusokuTaishoshaIchiranhyoBuilder builder = new NinteiChosaTokusokuTaishoshaIchiranhyoBulider(editor);
        reportSourceWriter.writeLine(builder);
    }
}
