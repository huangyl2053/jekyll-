/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200024;

import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200024.ShokanbaraiSashitomeTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200024_償還払支給差止対象者一覧表のReport
 *
 * @reamsid_L DBC-1000-160 liwul
 */
public class ShokanbaraiSashitomeTaishoshaIchiranReport extends Report<ShokanbaraiSashitomeTaishoshaIchiranSource> {

    private final ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem paramter;

    /**
     * インスタンスを生成します
     *
     * @param paramter 帳票用のentity
     */
    public ShokanbaraiSashitomeTaishoshaIchiranReport(
            ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem paramter) {
        this.paramter = paramter;
    }

    @Override
    protected void writeBy(ReportSourceWriter<ShokanbaraiSashitomeTaishoshaIchiranSource> writer) {
        writeLine(writer, paramter);
    }

    private void writeLine(ReportSourceWriter<ShokanbaraiSashitomeTaishoshaIchiranSource> writer,
            ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem paramter) {
        IShokanbaraiSashitomeTaishoshaIchiranEditor editor = new ShokanbaraiSashitomeTaishoshaIchiranEditor(paramter);
        IShokanbaraiSashitomeTaishoshaIchiranBuilder builder = new ShokanbaraiSashitomeTaishoshaIchiranBuilder(editor);
        writer.writeLine(builder);
    }
}
