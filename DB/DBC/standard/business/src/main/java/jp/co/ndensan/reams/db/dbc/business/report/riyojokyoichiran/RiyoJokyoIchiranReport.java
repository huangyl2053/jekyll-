/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyoichiran.RiyoJokyoIchiranReportSource;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoIchiranEntity;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200004_利用状況一覧表Reportクラスです。
 *
 * @reamsid_L DBC-3500-040 lizhuoxuan
 */
public class RiyoJokyoIchiranReport extends Report<RiyoJokyoIchiranReportSource> {

    private final RiyoJokyoIchiranEntity deta;

    /**
     * インスタンスを生成します。
     *
     * @param deta 利用状況一覧表パラメータ
     */
    public RiyoJokyoIchiranReport(RiyoJokyoIchiranEntity deta) {
        this.deta = deta;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiyoJokyoIchiranReportSource> reportSourceWriter) {
        IRiyoJokyoIchiranEditor editor = new RiyoJokyoIchiranEditor(deta);
        IRiyoJokyoIchiranBuilder builder = new RiyoJokyoIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
