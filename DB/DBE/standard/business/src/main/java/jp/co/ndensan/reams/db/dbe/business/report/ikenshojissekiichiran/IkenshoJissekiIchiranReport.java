/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenshojissekiichiran.IkenshoJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成実績集計表のReportです。
 *
 * @reamsid_L DBE-1690-040 dongyabin
 */
public class IkenshoJissekiIchiranReport extends Report<IkenshoJissekiIchiranReportSource> {

    private final IkenshoJissekiIchiranEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public IkenshoJissekiIchiranReport(IkenshoJissekiIchiranEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoJissekiIchiranReportSource> reportSourceWriter) {
        IIkenshoJissekiIchiranEditor editor = new IkenshoJissekiIchiranEditor(data);
        IIkenshoJissekiIchiranBuilder builder = new IkenshoJissekiIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
