/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    protected void writeBy(ReportSourceWriter<KogakuJigyoShinseishoHakkoIchiranSource> reportSourceWriter) {
        IOutputOrder 出力順 = parameter.get出力順();
        ShinseiJohoChohyoTempEntity 帳票出力対象データ = parameter.get帳票出力対象データ();
        RDateTime システム日付 = parameter.getシステム日付();
        RString 連番 = parameter.get連番();
        RString 市町村名 = parameter.get市町村名();

        KogakuJigyoShinseishoHakkoIchiranEditor editor = new KogakuJigyoShinseishoHakkoIchiranEditor(出力順,
                帳票出力対象データ, システム日付, 連番, 市町村名);
        KogakuJigyoShinseishoHakkoIchiranBuilder builder = new KogakuJigyoShinseishoHakkoIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
