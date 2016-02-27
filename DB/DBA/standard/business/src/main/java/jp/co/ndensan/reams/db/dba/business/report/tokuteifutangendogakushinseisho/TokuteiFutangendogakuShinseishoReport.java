/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険特定負担限度額申請書のReportです。
 */
public class TokuteiFutangendogakuShinseishoReport extends Report<TokuteiFutangendogakuShinseishoReportSource> {

    private final TokuteiFutangendogakuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険特定負担限度額申請書のITEM
     * @return 介護保険特定負担限度額申請書のReport
     */
    public static TokuteiFutangendogakuShinseishoReport createFrom(
            TokuteiFutangendogakuShinseishoItem item) {

        return new TokuteiFutangendogakuShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険特定負担限度額申請書のITEM
     */
    protected TokuteiFutangendogakuShinseishoReport(TokuteiFutangendogakuShinseishoItem item) {

        this.item = item;
    }

    /**
     * 護保険特定負担限度額申請書の印刷処理です。
     * @param reportSourceWriter 護保険特定負担限度額申請書の帳票データ
     */
    @Override
    public void writeBy(ReportSourceWriter<TokuteiFutangendogakuShinseishoReportSource> reportSourceWriter) {
        ITokuteiFutangendogakuShinseishoEditor editor = new TokuteiFutangendogakuShinseishoEditor(item);
        ITokuteiFutangendogakuShinseishoBuilder builder = new TokuteiFutangendogakuShinseishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
