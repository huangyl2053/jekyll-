/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事前審査結果一覧表のReportです。
 *
 * @reamsid_L DBE-1640-040 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranReport extends Report<ShinsakaiJizenshinsakekkaIchiranReportSource> {

    private final ShinsakaiJizenshinsakekkaIchiranEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 帳票発行のdataList
     */
    public ShinsakaiJizenshinsakekkaIchiranReport(ShinsakaiJizenshinsakekkaIchiranEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiJizenshinsakekkaIchiranReportSource> reportSourceWriter) {
        IShinsakaiJizenshinsakekkaIchiranEditor editor = new ShinsakaiJizenshinsakekkaIchiranEditor(data);
        IShinsakaiJizenshinsakekkaIchiranBuilder builder = new ShinsakaiJizenshinsakekkaIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
