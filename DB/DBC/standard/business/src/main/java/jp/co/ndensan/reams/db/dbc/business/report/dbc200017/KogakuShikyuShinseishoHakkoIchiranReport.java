/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200017;

import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranParamter;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200017_高額介護サービス費支給申請書発行一覧表Report
 *
 * @reamsid_L DBC-4770-130 jiangxiaolong
 */
public class KogakuShikyuShinseishoHakkoIchiranReport
        extends Report<KogakuShikyuShinseishoHakkoIchiranSource> {

    private final KogakuJigyoShinseishoHakkoIchiranParamter paramter;

    /**
     * インスタンスを生成します
     *
     * @param paramter KogakuJigyoShinseishoHakkoIchiranParamter
     */
    public KogakuShikyuShinseishoHakkoIchiranReport(
            KogakuJigyoShinseishoHakkoIchiranParamter paramter) {
        this.paramter = paramter;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuShinseishoHakkoIchiranSource> writer) {
        writeLine(writer, paramter);
    }

    private void writeLine(ReportSourceWriter<KogakuShikyuShinseishoHakkoIchiranSource> writer,
            KogakuJigyoShinseishoHakkoIchiranParamter paramter) {
        IKogakuShikyuShinseishoHakkoIchiranEditor bodyEditor
                = new KogakuShikyuShinseishoHakkoIchiranEditor(paramter);
        IKogakuShikyuShinseishoHakkoIchiranBuilder builder
                = new KogakuShikyuShinseishoHakkoIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
