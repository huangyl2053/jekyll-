/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-4770-120 jianglaisheng
 */
public class KogakuJigyoShinseishoHakkoIchiranReport extends Report<KogakuJigyoShinseishoHakkoIchiranSource> {

    private final KogakuJigyoShinseishoHakkoIchiranParamter parameter;

    /**
     * インスタンスを生成します。
     *
     * @param parameter KogakuJigyoShikyuShinseishoYuchoParameter
     */
    public KogakuJigyoShinseishoHakkoIchiranReport(KogakuJigyoShinseishoHakkoIchiranParamter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuJigyoShinseishoHakkoIchiranSource> reportSourceWriter) {

        KogakuJigyoShinseishoHakkoIchiranEditor editor = new KogakuJigyoShinseishoHakkoIchiranEditor(parameter);
        KogakuJigyoShinseishoHakkoIchiranBuilder builder = new KogakuJigyoShinseishoHakkoIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
