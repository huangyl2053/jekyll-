/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護保険診断命令書のReportです。
 */
public class KaigohokenShindanMeireishoReport extends Report<KaigohokenShindanMeireishoReportSource> {

    private final KaigohokenShindanMeireishoHeaderItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護保険診断命令書ヘッダのITEM
     * @return 介護保険診断命令書のReport
     */
    public static KaigohokenShindanMeireishoReport createFrom(
            KaigohokenShindanMeireishoHeaderItem headItem) {

        return new KaigohokenShindanMeireishoReport(headItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護保険診断命令書ヘッダのITEM
     */
    protected KaigohokenShindanMeireishoReport(
            KaigohokenShindanMeireishoHeaderItem headItem) {
        this.headItem = headItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter) {
        IKaigohokenShindanMeireishoEditor headerEditor = new KaigohokenShindanMeireishoHeaderEditor(headItem);
        IKaigohokenShindanMeireishoBuider buider = new KaigohokenShindanMeireishoBuiderImpl(headerEditor);
        reportSourceWriter.writeLine(buider);
    }
}
