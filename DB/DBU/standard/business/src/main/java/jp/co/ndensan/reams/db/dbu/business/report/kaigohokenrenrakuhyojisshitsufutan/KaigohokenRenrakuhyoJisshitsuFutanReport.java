/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan.KaigohokenRenrakuhyoJisshitsuFutanReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険連絡票_実質負担軽減者用のReportです。
 *
 * @reamsid_L DBU-1290-060 wangrenze
 */
public class KaigohokenRenrakuhyoJisshitsuFutanReport extends Report<KaigohokenRenrakuhyoJisshitsuFutanReportSource> {

    private final KaigohokenRenrakuhyoJisshitsuFutan hold;

    /**
     * インスタンスを生成します。
     *
     * @param hold 申請に関する帳票発行
     */
    public KaigohokenRenrakuhyoJisshitsuFutanReport(KaigohokenRenrakuhyoJisshitsuFutan hold) {
        this.hold = hold;
    }

    /**
     * インスタンスを生成します。
     *
     * @param hold KaigohokenRenrakuhyoJisshitsuFutan
     * @return KaigohokenRenrakuhyoJisshitsuFutanReport
     */
    public static KaigohokenRenrakuhyoJisshitsuFutanReport createReport(KaigohokenRenrakuhyoJisshitsuFutan hold) {
        return new KaigohokenRenrakuhyoJisshitsuFutanReport(hold);
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigohokenRenrakuhyoJisshitsuFutanReportSource> reportSourceWriter) {

        IKaigohokenRenrakuhyoJisshitsuFutanEditor editor = new KaigohokenRenrakuhyoJisshitsuFutanEditor(hold);
        IKaigohokenRenrakuhyoJisshitsuFutanBuilder builder = new KaigohokenRenrakuhyoJisshitsuFutanBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
