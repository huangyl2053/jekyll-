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
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReport extends Report<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書督促対象者一覧表のITEM
     * @return 主治医意見書督促対象者一覧表のReport
     */
    public static NinteiChosaTokusokuTaishoshaIchiranhyoReport createFrom(NinteiChosaTokusokuTaishoshaIchiranhyoItem item) {
        return new NinteiChosaTokusokuTaishoshaIchiranhyoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書督促対象者一覧表のITEM
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoReport(NinteiChosaTokusokuTaishoshaIchiranhyoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter) {
        NinteiChosaTokusokuTaishoshaIchiranhyoHeadEditor editor = new NinteiChosaTokusokuTaishoshaIchiranhyoHeadEditor(item);
        NinteiChosaTokusokuTaishoshaIchiranhyoBuliderImpl builder = new NinteiChosaTokusokuTaishoshaIchiranhyoBuliderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
