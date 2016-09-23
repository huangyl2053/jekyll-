/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.koseitaishojissekiichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.koseitaishojissekiichiran.KoseiTaishoJissekiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200097_更正対象給付実績一覧表 のPropertyクラスです。
 *
 * @reamsid_L DBC-4960-040 qinzhen
 */
public class KoseiTaishoJissekiIchiranProperty extends
        ReportPropertyBase<KoseiTaishoJissekiIchiranSource> {

    /**
     * コンストラクタです。
     */
    public KoseiTaishoJissekiIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200096.getReportId());
    }
}
