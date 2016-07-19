/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo;

import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険連絡票のReportです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
public final class KaigohokenRenrakuhyoReport extends Report<KaigohokenRenrakuhyoReportSource> {

    private final KaigohokenRenrakuhyo hold;

    private KaigohokenRenrakuhyoReport(KaigohokenRenrakuhyo hold) {
        this.hold = hold;
    }

    /**
     * インスタンスを生成します。
     *
     * @param hold 介護保険住所地特例適用・変更・終了届のEntity
     * @return KaigohokenRenrakuhyoReport
     */
    public static KaigohokenRenrakuhyoReport createReport(KaigohokenRenrakuhyo hold) {
        return new KaigohokenRenrakuhyoReport(hold);
    }

    @Override
    protected void writeBy(ReportSourceWriter<KaigohokenRenrakuhyoReportSource> writer) {
        IKaigohokenRenrakuhyoEditor joho = new KaigohokenRenrakuhyoEditor(hold);
        IKaigohokenRenrakuhyoBuilder builder = new KaigohokenRenrakuhyoBuilderImpl(joho);
        writer.writeLine(builder);
    }

}
