/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMNN1004_事業分支給額計算 のPropertyクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
public class GassanJigyobunKekkaIchiranProperty extends
        ReportPropertyBase<GassanJigyobunKekkaIchiranSource> {

    /**
     * コンストラクタです。
     */
    public GassanJigyobunKekkaIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200204.getReportId());
    }
}
