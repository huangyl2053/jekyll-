/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuichiran.ChosahoshuichiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査報酬一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1940-030 jinjue
 */
public class ChosahoshuichiranReport extends Report<ChosahoshuichiranReportSource> {

    private final NinteiChosaHoshuShokaiCsvEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 認定調査報酬照会帳票のたEntity
     */
    public ChosahoshuichiranReport(NinteiChosaHoshuShokaiCsvEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahoshuichiranReportSource> reportSourceWriter) {
        IChosahoshuichiranEditor editor = new ChosahoshuichiranEditor(data);
        IChosahoshuichiranBuilder builder = new ChosahoshuichiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
