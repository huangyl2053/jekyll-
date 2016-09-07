/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200090_負担割合証発行一覧表 Report
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
public class FutanWariaiShoHakkoIchiranReport extends Report<FutanWariaiShoHakkoIchiranSource> {

    private final FutanWariaiShoHakkoIchiranEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoHakkoIchiranEntity}
     */
    public FutanWariaiShoHakkoIchiranReport(FutanWariaiShoHakkoIchiranEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoHakkoIchiranSource> reportSourceWriter) {
        IFutanWariaiShoHakkoIchiranEditor editor = new FutanWariaiShoHakkoIchiranEditor(entity);
        IFutanWariaiShoHakkoIchiranBuilder builder = new FutanWariaiShoHakkoIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
