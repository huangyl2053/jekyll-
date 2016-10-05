/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 受給者給付実績一覧表 のPropertyです。
 *
 * @reamsid_L DBC-3070-040 dangjingjing
 */
public class JukyushaKyufuJissekiIchiranProperty extends ReportPropertyBase<JukyushaKyufuJissekiIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public JukyushaKyufuJissekiIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200002.getReportId());
    }
}
