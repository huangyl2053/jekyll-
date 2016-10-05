/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200013;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200013.JuryoIninShoninKakuninshoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN32002_受領委任契約承認確認書発行一覧表Report
 *
 * @reamsid_L DBC-1910-070 jiangxiaolong
 */
public class JuryoIninShoninKakuninshoIchiranReport
        extends Report<JuryoIninShoninKakuninshoIchiranSource> {

    private final JuryoIninShoninKakuninshoIchiranParameter parameter;

    /**
     * コンストラクタです。
     *
     * @param parameter JuryoIninShoninKakuninshoIchiranParameter
     */
    public JuryoIninShoninKakuninshoIchiranReport(JuryoIninShoninKakuninshoIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<JuryoIninShoninKakuninshoIchiranSource> writer) {
        writeLine(writer, parameter);
    }

    private void writeLine(ReportSourceWriter<JuryoIninShoninKakuninshoIchiranSource> writer,
            JuryoIninShoninKakuninshoIchiranParameter parameter) {
        IJuryoIninShoninKakuninshoIchiranEditor headerEditor
                = new JuryoIninShoninKakuninshoIchiranHeaderEditor(parameter);
        IJuryoIninShoninKakuninshoIchiranEditor bodyEditor
                = new JuryoIninShoninKakuninshoIchiranBodyEditor(parameter.get受領委任契約承認確認書発行一覧表());
        IJuryoIninShoninKakuninshoIchiranBuilder builder
                = new JuryoIninShoninKakuninshoIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
