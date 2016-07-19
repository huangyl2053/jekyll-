/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.GokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran.IkenHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成報酬実績集計表のReportです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenHoshuIchiranReport extends Report<IkenHoshuIchiranReportSource> {

    private final IkenHoshuIchiranEntity data;
    private final GokeiEntity gokeiEntity;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param gokeiEntity 主治医意見書作成報酬の合計データ
     */
    public IkenHoshuIchiranReport(IkenHoshuIchiranEntity data, GokeiEntity gokeiEntity) {
        this.data = data;
        this.gokeiEntity = gokeiEntity;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenHoshuIchiranReportSource> reportSourceWriter) {
        IIkenHoshuIchiranEditor bodyEditor = new IkenHoshuIchiranBodyEditor(data, gokeiEntity);
        IIkenHoshuIchiranEditor headEditor = new IkenHoshuIchiranHeadEditor(data);
        IIkenHoshuIchiranBuilder builder = new IkenHoshuIchiranBuilder(bodyEditor, headEditor);
        reportSourceWriter.writeLine(builder);
    }
}
