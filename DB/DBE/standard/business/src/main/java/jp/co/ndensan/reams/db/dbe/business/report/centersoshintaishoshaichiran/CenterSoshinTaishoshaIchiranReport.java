/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.centersoshintaishoshaichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterSoshinTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.centersoshintaishoshaichiran.CenterSoshinTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 完了処理・センター送信のレポートです。
 *
 * @reamsid_L DBE_1520_DBEMN91010 n8466
 */
public class CenterSoshinTaishoshaIchiranReport extends Report<CenterSoshinTaishoshaIchiranReportSource> {

    private final RString printTimeStamp;
    private final CenterSoshinTaishoshaIchiranEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp 作成日時
     * @param data dataList センター送信対象者一覧
     */
    public CenterSoshinTaishoshaIchiranReport(RString printTimeStamp, CenterSoshinTaishoshaIchiranEntity data) {
        this.printTimeStamp = printTimeStamp;
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<CenterSoshinTaishoshaIchiranReportSource> reportSourceWriter) {
        ICenterSoshinTaishoshaIchiranEditor editor = new CenterSoshinTaishoshaIchiranEditor(printTimeStamp, data);
        ICenterSoshinTaishoshaIchiranBuidler builder = new CenterSoshinTaishoshaIchiranBuidler(editor);
        reportSourceWriter.writeLine(builder);
    }
}
