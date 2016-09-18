/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200025;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200025_償還連絡票送付一覧表Report
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
public class ShokanRenrakuhyoSofuIchiranReport
        extends Report<ShokanRenrakuhyoSofuIchiranSource> {

    private final ShokanRenrakuhyoSofuIchiranParameter parameter;

    /**
     *
     * @param parameter ShokanRenrakuhyoSofuIchiranParameter
     */
    public ShokanRenrakuhyoSofuIchiranReport(ShokanRenrakuhyoSofuIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanRenrakuhyoSofuIchiranSource> writer) {
        writeLine(writer, parameter);
    }

    private void writeLine(ReportSourceWriter<ShokanRenrakuhyoSofuIchiranSource> writer,
            ShokanRenrakuhyoSofuIchiranParameter parameter) {
        IShokanRenrakuhyoSofuIchiranEditor headerEditor
                = new ShokanRenrakuhyoSofuIchiranHeaderEditor(parameter);
        IShokanRenrakuhyoSofuIchiranEditor bodyEditor
                = new ShokanRenrakuhyoSofuIchiranBodyEditor(parameter);
        IShokanRenrakuhyoSofuIchiranBuilder builder
                = new ShokanRenrakuhyoSofuIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
