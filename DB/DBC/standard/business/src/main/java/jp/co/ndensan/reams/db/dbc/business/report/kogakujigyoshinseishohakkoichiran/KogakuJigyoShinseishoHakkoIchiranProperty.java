/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表のプロパティです。
 *
 * @reamsid_L DBC-4770-120 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJigyoShinseishoHakkoIchiranProperty
        extends ReportPropertyBase<KogakuJigyoShinseishoHakkoIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public KogakuJigyoShinseishoHakkoIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200091.getReportId());
    }
}
