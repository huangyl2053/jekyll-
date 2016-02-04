/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.choshuyuyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.choshuyuyoshinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険料徴収猶予申請書の帳票を作成します。
 */
public class HokenryoGenmenChoshuYoyuShinseishoReport extends
        Report<HokenryoGenmenChoshuYoyuShinseishoReportSource> {

    private final HokenryoGenmenChoshuYoyuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険料徴収猶予申請書のItem
     * @return 介護保険料徴収猶予申請書のReport
     */
    public static HokenryoGenmenChoshuYoyuShinseishoReport createFrom(
            HokenryoGenmenChoshuYoyuShinseishoItem item) {
        return new HokenryoGenmenChoshuYoyuShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険料徴収猶予申請書のItem
     */
    protected HokenryoGenmenChoshuYoyuShinseishoReport(HokenryoGenmenChoshuYoyuShinseishoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoGenmenChoshuYoyuShinseishoReportSource> reportSourceWriter) {
        IHokenryoGenmenChoshuYoyuShinseishoEditor editor = new HokenryoGenmenChoshuYoyuShinseishoEditorImpl(item);
        IHokenryoGenmenChoshuYoyuShinseishoBuilder builder = new HokenryoGenmenChoshuYoyuShinseishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
