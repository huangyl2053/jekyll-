/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200061;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200061.ServiceCodeIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMNJ2006_サービスコード一覧表Report
 *
 * @reamsid_L DBC-3310-040 jiangxiaolong
 */
public class ServiceCodeIchiranReport
        extends Report<ServiceCodeIchiranSource> {

    private final ServiceCodeIchiranParameter parameter;

    /**
     * コンストラクタです。
     *
     * @param parameter ServiceCodeIchiranParameter
     */
    public ServiceCodeIchiranReport(ServiceCodeIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<ServiceCodeIchiranSource> writer) {
        writeLine(writer, parameter);
    }

    private void writeLine(ReportSourceWriter<ServiceCodeIchiranSource> writer,
            ServiceCodeIchiranParameter parameter) {
        IServiceCodeIchiranEditor headerEditor
                = new ServiceCodeIchiranHeaderEditor(parameter);
        IServiceCodeIchiranEditor bodyEditor
                = new ServiceCodeIchiranBodyEditor(parameter);
        IServiceCodeIchiranBuilder builder
                = new ServiceCodeIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
