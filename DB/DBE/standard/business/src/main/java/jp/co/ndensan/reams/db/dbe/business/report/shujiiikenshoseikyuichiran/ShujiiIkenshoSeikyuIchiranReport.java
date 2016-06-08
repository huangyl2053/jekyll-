/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成料請求一覧表のReportです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
public class ShujiiIkenshoSeikyuIchiranReport extends Report<ShujiiIkenshoSeikyuIchiranReportSource> {

    private final List<ShujiiIkenshoSeikyuIchiranEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public ShujiiIkenshoSeikyuIchiranReport(List<ShujiiIkenshoSeikyuIchiranEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIkenshoSeikyuIchiranReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            IShujiiIkenshoSeikyuIchiranEditor editor = new ShujiiIkenshoSeikyuIchiranEditor(data.get(i), i);
            IShujiiIkenshoSeikyuIchiranBuilder builder = new ShujiiIkenshoSeikyuIchiranBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            ShujiiIkenshoSeikyuIchiranEntity entity = new ShujiiIkenshoSeikyuIchiranEntity();
            entity.set氏名(new RString("該当データがありません"));
            IShujiiIkenshoSeikyuIchiranEditor editor = new ShujiiIkenshoSeikyuIchiranEditor(entity, -1);
            IShujiiIkenshoSeikyuIchiranBuilder builder = new ShujiiIkenshoSeikyuIchiranBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
