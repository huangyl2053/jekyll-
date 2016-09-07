/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表 のPropertyクラスです。
 *
 * @reamsid_L DBC-2710-040 qinzhen
 */
public class GassanKyufujissekiSofuIchiranProperty extends
        ReportPropertyBase<GassanKyufujissekiSofuIchiranSource> {

    /**
     * コンストラクタです。
     */
    public GassanKyufujissekiSofuIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200042.getReportId());
    }
}
