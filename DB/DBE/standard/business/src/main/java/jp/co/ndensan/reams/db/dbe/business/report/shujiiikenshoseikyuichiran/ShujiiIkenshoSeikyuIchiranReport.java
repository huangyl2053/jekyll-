/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成料請求一覧表のReportです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
public class ShujiiIkenshoSeikyuIchiranReport extends Report<ShujiiIkenshoSeikyuIchiranReportSource> {

    private final ShujiiIkenshoSeikyuIchiranEntity data;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index int
     */
    public ShujiiIkenshoSeikyuIchiranReport(ShujiiIkenshoSeikyuIchiranEntity data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSeikyuIchiranReportSource> reportSourceWriter) {
        IShujiiIkenshoSeikyuIchiranEditor editor = new ShujiiIkenshoSeikyuIchiranEditor(data, index);
        IShujiiIkenshoSeikyuIchiranBuilder builder = new ShujiiIkenshoSeikyuIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
