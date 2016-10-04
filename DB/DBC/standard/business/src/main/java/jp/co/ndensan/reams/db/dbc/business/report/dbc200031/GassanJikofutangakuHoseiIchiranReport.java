/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200031;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200031.GassanJikofutangakuHoseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN62002_高額合算自己負担額補正結果一覧表Report
 *
 * @reamsid_L DBC-2320-040 jiangxiaolong
 */
public class GassanJikofutangakuHoseiIchiranReport
        extends Report<GassanJikofutangakuHoseiIchiranSource> {

    private final GassanJikofutangakuHoseiIchiranParameter parameter;

    /**
     * コンストラクタです。
     *
     * @param parameter GassanJikofutangakuHoseiIchiranParameter
     */
    public GassanJikofutangakuHoseiIchiranReport(GassanJikofutangakuHoseiIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJikofutangakuHoseiIchiranSource> writer) {
        writeLine(writer, parameter);
    }

    private void writeLine(ReportSourceWriter<GassanJikofutangakuHoseiIchiranSource> writer,
            GassanJikofutangakuHoseiIchiranParameter parameter) {
        IGassanJikofutangakuHoseiIchiranEditor headerEditor
                = new GassanJikofutangakuHoseiIchiranHeaderEditor(parameter);
        IGassanJikofutangakuHoseiIchiranEditor bodyEditor
                = new GassanJikofutangakuHoseiIchiranBodyEditor(parameter.get高額合算自己負担額補正一覧表());
        IGassanJikofutangakuHoseiIchiranBuilder builder
                = new GassanJikofutangakuHoseiIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
