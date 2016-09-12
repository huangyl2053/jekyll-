/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事前審査結果一覧表のReportです。
 *
 * @reamsid_L DBE-1640-040 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranReport extends Report<ShinsakaiJizenshinsakekkaIchiranReportSource> {

    private final ShinsakaiJizenshinsakekkaIchiranBusiness data;

    /**
     * インスタンスを生成します。
     *
     * @param data 帳票発行のdata
     */
    public ShinsakaiJizenshinsakekkaIchiranReport(ShinsakaiJizenshinsakekkaIchiranBusiness data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiJizenshinsakekkaIchiranReportSource> reportSourceWriter) {
        IShinsakaiJizenshinsakekkaIchiranEditor editor = new ShinsakaiJizenshinsakekkaIchiranEditor(data);
        IShinsakaiJizenshinsakekkaIchiranBuilder builder = new ShinsakaiJizenshinsakekkaIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
