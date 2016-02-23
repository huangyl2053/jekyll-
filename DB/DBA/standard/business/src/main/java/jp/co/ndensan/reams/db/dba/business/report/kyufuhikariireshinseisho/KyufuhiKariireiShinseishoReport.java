/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikariireshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikariireshinseisho.KyufuhiKariireiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険給付費借入申請書の帳票を作成します。
 */
public class KyufuhiKariireiShinseishoReport extends Report<KyufuhiKariireiShinseishoReportSource> {

    private final KyufuhiKariireiShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険給付費借入申請書のItem
     * @return 介護保険給付費借入申請書のReport
     */
    public static KyufuhiKariireiShinseishoReport createFrom(
            KyufuhiKariireiShinseishoItem item) {
        return new KyufuhiKariireiShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険給付費借入申請書のItem
     */
    protected KyufuhiKariireiShinseishoReport(KyufuhiKariireiShinseishoItem item) {
        this.item = item;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiKariireiShinseishoReportSource> reportSourceWriter) {
        IKyufuhiKariireiShinseishoEditor editor = new KyufuhiKariireiShinseishoEditorImpl(item);
        IKyufuhiKariireiShinseishoBuilder builder = new KyufuhiKariireiShinseishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
